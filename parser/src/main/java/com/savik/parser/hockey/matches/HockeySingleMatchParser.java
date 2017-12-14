package com.savik.parser.hockey.matches;

import com.savik.Season;
import com.savik.hockey.model.HockeyBookieStats;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.Downloader;
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


@Service
public class HockeySingleMatchParser {

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    Downloader downloader;

    public HockeyMatch parse(String matchId, HockeyChampionship footballChampionship, Season season) {

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

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship(homeTeam, footballChampionship);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship(guestTeam, footballChampionship);

        Element parts = generalInfo.getElementById("parts");
        Elements allRows = parts.select("tr");
        int secondTimeIndex = parts.select("tr .h-part").get(1).parent().siblingIndex();
        int thirdTimeIndex = parts.select("tr .h-part").get(2).parent().siblingIndex();
        Integer overtimeIndex = null;
        int finalPeriodIndex = allRows.size();
        if(parts.select("tr .h-part").size() > 3) {
            finalPeriodIndex = parts.select("tr .h-part").get(3).parent().siblingIndex();
            overtimeIndex = parts.select("tr .h-part").get(4).parent().siblingIndex();
        }

        List<Element> firstPeriodRows = allRows.subList(0, secondTimeIndex);
        List<Element> secondPeriodRows = allRows.subList(secondTimeIndex, thirdTimeIndex);
        List<Element> thirdPeriodRows = allRows.subList(thirdTimeIndex, finalPeriodIndex);
        List<Element> overtimeRows  =  overtimeIndex == null ? null : allRows.subList(finalPeriodIndex, overtimeIndex);

        HockeyMatchInfoParser.GeneralInfoDto matchPeriodInfo = HockeyMatchInfoParser.parseGeneralInfo(
                new Elements(allRows.subList(0,  overtimeIndex == null ? finalPeriodIndex : overtimeIndex)), null
        );
        HockeyMatchInfoParser.GeneralInfoDto firstPeriodInfo =
                HockeyMatchInfoParser.parseGeneralInfo(new Elements(firstPeriodRows), 1);
        HockeyMatchInfoParser.GeneralInfoDto secondPeriodInfo =
                HockeyMatchInfoParser.parseGeneralInfo(new Elements(secondPeriodRows), 2);
        HockeyMatchInfoParser.GeneralInfoDto thirdPeriodInfo =
                HockeyMatchInfoParser.parseGeneralInfo(new Elements(thirdPeriodRows), 3);

        HockeyMatchInfoParser.GeneralInfoDto overtimeInfo = null;
        if(overtimeIndex != null) {
            overtimeInfo = HockeyMatchInfoParser.parseGeneralInfo(new Elements(overtimeRows), 4);
        }


        String matchPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Матч)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Матч)").get(0).parent().parent().attr("id");

        String firstPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(1-й период)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(1-й период)").get(0).parent().parent().attr("id");

        String secondPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(2-й период)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(2-й период)").get(0).parent().parent().attr("id");

        String thirdPeriodStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(3-й период)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(3-й период)").get(0).parent().parent().attr("id");

        String overtimeStatsSelector = statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Овертайм)").isEmpty() ?
                null : statsInfo.select(".ifmenu li[id$=\"statistic\"] a:containsOwn(Овертайм)").get(0).parent().parent().attr("id");


        HockeyMatchInfoParser.StatsInfoDto matchStats =
                matchPeriodStatsSelector != null ?
                        HockeyMatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + matchPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even")) :

                        !CollectionUtils.isEmpty(statsInfo.select("table.parts").select("tr.odd,tr.even")) ?

                                HockeyMatchInfoParser.parseStats(statsInfo
                                        .select("table.parts")
                                        .select("tr.odd,tr.even")) :
                                null;

        HockeyMatchInfoParser.StatsInfoDto firstPeriodStats =
                firstPeriodStatsSelector == null ?
                        null :
                        HockeyMatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + firstPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));

        HockeyMatchInfoParser.StatsInfoDto secondPeriodStats =
                secondPeriodStatsSelector == null ?
                        null :
                        HockeyMatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + secondPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));

        HockeyMatchInfoParser.StatsInfoDto thirdPeriodStats =
                thirdPeriodStatsSelector == null ?
                        null :
                        HockeyMatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + thirdPeriodStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));

        HockeyMatchInfoParser.StatsInfoDto overtimeStats =
                overtimeStatsSelector == null ?
                        null :
                        HockeyMatchInfoParser.parseStats(statsInfo
                                .select("#tab-" + overtimeStatsSelector + " .parts")
                                .select("tr.odd,tr.even"));


        HockeyBookieStats hockeyBookieStats = null;
        Elements odds = oddsInfo.select("#block-1x2 tr.odd");
        if (!odds.isEmpty()) {
            List<Element> rates = odds.get(0).select("td > span");
            hockeyBookieStats = HockeyBookieStats.builder()
                    .homeRate(Double.valueOf(rates.get(0).text()))
                    .drawRate(Double.valueOf(rates.get(1).text()))
                    .guestRate(Double.valueOf(rates.get(2).text()))
                    .build();
        }

        HockeyMatch hockeyMatch = HockeyMatchCreator.builder()
                .matchGeneralInfoDto(matchPeriodInfo)
                .firstPeriodGeneralInfoDto(firstPeriodInfo)
                .secondPeriodGeneralInfoDto(secondPeriodInfo)
                .thirdPeriodGeneralInfoDto(thirdPeriodInfo)
                .overtimeGeneralInfoDto(overtimeInfo)
                .matchStatsInfoDto(matchStats)
                .firstPeriodStatsInfoDto(firstPeriodStats)
                .secondPeriodStatsInfoDto(secondPeriodStats)
                .thirdPeriodStatsInfoDto(thirdPeriodStats)
                .overtimeStatsInfoDto(overtimeStats)
                .homeTeam(home)
                .guestTeam(guest)
                .date(dateTime)
                .championship(footballChampionship)
                .season(season)
                .myscoreCode(matchId)
                .bookieStats(hockeyBookieStats)
                .build()
                .createMatch();

        return hockeyMatch;
    }
}
