package com.savik.parser.football;/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.annotation.PostConstruct;

import com.savik.football.model.Championship;
import com.savik.football.model.Match;
import com.savik.football.model.Season;
import com.savik.football.model.Team;
import com.savik.football.repository.MatchRepository;
import com.savik.football.repository.TeamRepository;
import com.savik.parser.Downloader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class Test {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    Downloader downloader;

    @PostConstruct
    public void parse() throws IOException {

        // String url = "http://d.myscore.com.ua/x/feed/d_su_Ae9H9qT0_ru_1"; // основная инфа
        String url = "http://d.myscore.com.ua/x/feed/d_st_Ae9H9qT0_ru_1"; // статистика
        // String url = "http://d.myscore.com.ua/x/feed/d_od_Ae9H9qT0_ru_1_eu";

        String matchId = "GW4G2O9L";
        Document generalInfo = downloader.downloadGeneralInfo(matchId);
        Document statsInfo = downloader.downloadStatsInfo(matchId);
        Document summaryInfo = downloader.downloadSummaryInfo(matchId);


        Championship championship = Championship.LA;
        Season season = Season.S2016;

        String homeTeam = summaryInfo.select(".tname-home a").text();
        String guestTeam = summaryInfo.select(".tname-away a").text();

        String outerHtml = summaryInfo.outerHtml();
        Long epoch = Long.valueOf(outerHtml.substring(
                outerHtml.indexOf("game_utime") + 13,
                outerHtml.indexOf("game_utime") + 23
        ));

        LocalDateTime dateTime = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();

        Team home = teamRepository.findOneByName(homeTeam);
        if (home == null) {
            home = teamRepository.save(Team.builder()
                                           .name(homeTeam)
                                           .championship(championship)
                                           .build());
        }

        Team guest = teamRepository.findOneByName(guestTeam);
        if (guest == null) {
            guest = teamRepository.save(Team.builder()
                                            .name(guestTeam)
                                            .championship(championship)
                                            .build());
        }


        Elements allRows = generalInfo.getElementById("parts").select("tr");
        int secondTimeIndex = generalInfo.getElementById("parts").select("tr .h-part").get(1).parent().siblingIndex();

        List<Element> firstPeriodRows = allRows.subList(0, secondTimeIndex);
        List<Element> secondPeriodRows = allRows.subList(secondTimeIndex, allRows.size());


        MatchParser.GeneralInfoDto matchPeriodInfo = MatchParser.parseGeneralInfo(new Elements(allRows));
        MatchParser.GeneralInfoDto firstPeriodInfo = MatchParser.parseGeneralInfo(new Elements(firstPeriodRows));
        MatchParser.GeneralInfoDto secondPeriodInfo = MatchParser.parseGeneralInfo(new Elements(secondPeriodRows));


        MatchParser.StatsInfoDto matchStats =
                MatchParser.parseStats(statsInfo.select("#tab-statistics-0-statistic .parts").select("tr.odd,tr.even"));

        MatchParser.StatsInfoDto firstPeriodStats =
                MatchParser.parseStats(statsInfo.select("#tab-statistics-1-statistic .parts").select("tr.odd,tr.even"));

        MatchParser.StatsInfoDto secondPeriodStats =
                MatchParser.parseStats(statsInfo.select("#tab-statistics-2-statistic .parts").select("tr.odd,tr.even"));


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

        matchRepository.save(match);

    }
}
