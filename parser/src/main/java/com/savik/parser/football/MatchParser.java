package com.savik.parser.football;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.savik.football.model.Championship;
import com.savik.football.model.Match;
import com.savik.football.model.Season;
import com.savik.football.model.Team;
import com.savik.football.repository.MatchRepository;
import com.savik.football.repository.TeamRepository;
import com.savik.parser.Downloader;
import com.savik.parser.LeagueParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class MatchParser {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    Downloader downloader;

    @Autowired
    LeagueParser leagueParser;

    public Match parse(String matchId, Championship championship, Season season) {

        Document generalInfo = downloader.downloadGeneralInfo(matchId);
        Document statsInfo = downloader.downloadStatsInfo(matchId);
        Document summaryInfo = downloader.downloadSummaryInfo(matchId);


        String homeTeam = summaryInfo.select(".tname-home a").text();
        String guestTeam = summaryInfo.select(".tname-away a").text();

        String outerHtml = summaryInfo.outerHtml();
        Long epoch = Long.valueOf(outerHtml.substring(
                outerHtml.indexOf("game_utime") + 13,
                outerHtml.indexOf("game_utime") + 23
        ));

        LocalDateTime dateTime = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();

        Team home = teamRepository.findOneByNameAndChampionship(homeTeam, championship);
        if (home == null) {
            home = teamRepository.save(Team.builder().name(homeTeam).championship(championship).build());
        }

        Team guest = teamRepository.findOneByNameAndChampionship(guestTeam, championship);
        if (guest == null) {
            guest = teamRepository.save(Team.builder().name(guestTeam).championship(championship).build());
        }


        Elements allRows = generalInfo.getElementById("parts").select("tr");
        int secondTimeIndex = generalInfo.getElementById("parts").select("tr .h-part").get(1).parent().siblingIndex();

        List<Element> firstPeriodRows = allRows.subList(0, secondTimeIndex);
        List<Element> secondPeriodRows = allRows.subList(secondTimeIndex, allRows.size());

        MatchInfoParser.GeneralInfoDto matchPeriodInfo = MatchInfoParser.parseGeneralInfo(new Elements(allRows));
        MatchInfoParser.GeneralInfoDto firstPeriodInfo =
                MatchInfoParser.parseGeneralInfo(new Elements(firstPeriodRows));
        MatchInfoParser.GeneralInfoDto secondPeriodInfo =
                MatchInfoParser.parseGeneralInfo(new Elements(secondPeriodRows));


        String matchPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Матч)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Матч)").get(0).parent().parent().attr("id");

        String firstPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(1-й тайм)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(1-й тайм)").get(0).parent().parent().attr("id");

        String secondPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(2-й тайм)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(2-й тайм)").get(0).parent().parent().attr("id");


        MatchInfoParser.StatsInfoDto matchStats =
                matchPeriodStatsSelector != null ?
                        MatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + matchPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even")) :

                        !CollectionUtils.isEmpty(statsInfo.select("table.parts").select("tr.odd,tr.even")) ?

                                MatchInfoParser.parseStats(statsInfo
                                        .select("table.parts")
                                        .select("tr.odd,tr.even")) :
                                null;

        MatchInfoParser.StatsInfoDto firstPeriodStats =
                firstPeriodStatsSelector == null ?
                        null :
                        MatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + firstPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));

        MatchInfoParser.StatsInfoDto secondPeriodStats =
                secondPeriodStatsSelector == null ?
                        null :
                        MatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + secondPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));


        Match match = MatchCreator.builder()
                .matchGeneralInfoDto(matchPeriodInfo)
                .firstPeriodGeneralInfoDto(firstPeriodInfo)
                .secondPeriodGeneralInfoDto(secondPeriodInfo)
                .matchStatsInfoDto(matchStats)
                .firstPeriodStatsInfoDto(firstPeriodStats)
                .secondPeriodStatsInfoDto(secondPeriodStats)
                .homeTeam(home)
                .guestTeam(guest)
                .date(dateTime)
                .championship(championship)
                .season(season)
                .myscoreCode(matchId)
                .build()
                .createMatch();

        return match;
    }
}
