package com.savik.parser.football.matches;

import com.savik.Season;
import com.savik.football.model.*;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.football.repository.FootballRefereeRepository;
import com.savik.football.repository.FootballTeamRepository;
import com.savik.parser.Downloader;
import com.savik.parser.LeagueParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class MatchParser {

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Autowired
    FootballMatchRepository footballMatchRepository;

    @Autowired
    FootballRefereeRepository footballRefereeRepository;

    @Autowired
    Downloader downloader;

    @Autowired
    LeagueParser leagueParser;

    public FootballMatch parse(String matchId, FootballChampionship footballChampionship, Season season) {

        Document generalInfo = downloader.downloadGeneralInfo(matchId);
        Document statsInfo = downloader.downloadStatsInfo(matchId);
        Document summaryInfo = downloader.downloadSummaryInfo(matchId);
        Document oddsInfo = downloader.downloadOddsInfo(matchId);


        String homeTeam = summaryInfo.select(".tname-home a").text();
        String guestTeam = summaryInfo.select(".tname-away a").text();

        String outerHtml = summaryInfo.outerHtml();
        Long epoch = Long.valueOf(outerHtml.substring(
                outerHtml.indexOf("game_utime") + 13,
                outerHtml.indexOf("game_utime") + 23
        ));

        LocalDateTime dateTime = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();

        FootballTeam home = footballTeamRepository.findOneByNameAndChampionship(homeTeam, footballChampionship);
        FootballTeam guest = footballTeamRepository.findOneByNameAndChampionship(guestTeam, footballChampionship);
        FootballReferee referee = getFootballReferee(generalInfo);

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


        FootballBookieStats footballBookieStats = null;
        Elements odds = oddsInfo.select("#block-1x2 tr.odd");
        if (!odds.isEmpty()) {
            List<Element> rates = odds.get(0).select("td > span");
            footballBookieStats = FootballBookieStats.builder()
                    .homeRate(Double.valueOf(rates.get(0).text()))
                    .drawRate(Double.valueOf(rates.get(1).text()))
                    .guestRate(Double.valueOf(rates.get(2).text()))
                    .build();
        }

        FootballMatch footballMatch = MatchCreator
                .builder()
                .matchGeneralInfoDto(matchPeriodInfo)
                .firstPeriodGeneralInfoDto(firstPeriodInfo)
                .secondPeriodGeneralInfoDto(secondPeriodInfo)
                .matchStatsInfoDto(matchStats)
                .firstPeriodStatsInfoDto(firstPeriodStats)
                .secondPeriodStatsInfoDto(secondPeriodStats)
                .homeTeam(home)
                .guestTeam(guest)
                .date(dateTime)
                .championship(footballChampionship)
                .season(season)
                .myscoreCode(matchId)
                .bookieStats(footballBookieStats)
                .footballReferee(referee)
                .build()
                .createMatch();

        return footballMatch;
    }

    private FootballReferee getFootballReferee(Document generalInfo) {
        Elements temp = generalInfo.select(".match-information");
        FootballReferee referee = null;
        if (!temp.isEmpty()) {
            Element matchInformation = temp.first();
            Elements contentTemp = matchInformation.select("tr.content");
            if (contentTemp.size() != 2) {
                throw new RuntimeException("content is invalid");
            }
            Element refereeBlock = contentTemp.first().select("td").first();
            String text = refereeBlock.text();
            String refereeName = text.replaceAll("Судья:", "").trim();
            referee = footballRefereeRepository.findOneByName(refereeName);
        }
        return referee;
    }
}
