package com.savik.parser.football;/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.savik.football.repository.TeamRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.savik.parser.Downloader;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class Test {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    Downloader downloader;

    @PostConstruct
    public void parse() throws IOException {

       // String url = "http://d.myscore.com.ua/x/feed/d_su_Ae9H9qT0_ru_1"; // основная инфа
         String url = "http://d.myscore.com.ua/x/feed/d_st_Ae9H9qT0_ru_1"; // статистика
        // String url = "http://d.myscore.com.ua/x/feed/d_od_Ae9H9qT0_ru_1_eu";
        Document document = Jsoup.connect(url)
                                 .header("X-Fsign", "SW9D1eZo").get();

        //downloader.downloadGeneralInfo("Ae9H9qT0");
        System.out.println(document.toString());

        MatchParser.StatsInfoDto matchStats =
                MatchParser.parseStats(document.select("#tab-statistics-0-statistic .parts").select("tr.odd,tr.even"));

        MatchParser.StatsInfoDto firstPeriodStats =
                MatchParser.parseStats(document.select("#tab-statistics-1-statistic .parts").select("tr.odd,tr.even"));

        MatchParser.StatsInfoDto secondPeriodStats =
                MatchParser.parseStats(document.select("#tab-statistics-2-statistic .parts").select("tr.odd,tr.even"));
        /*Element table = document.getElementById("parts");


        Elements allRows = table.select("tr");
        int secondTimeIndex = table.select("tr .h-part").get(1).parent().siblingIndex();

        List<Element> firstPeriodRows = allRows.subList(0, secondTimeIndex);
        List<Element> secondPeriodRows = allRows.subList(secondTimeIndex, allRows.size());


        MatchParser.GeneralInfoDto generalInfoDto = MatchParser.parseGeneralInfo(new Elements(secondPeriodRows));
        */
        String a = "";

    }
}
