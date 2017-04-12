package football;/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import football.MatchParser;
import football.model.Championship;
import football.model.Goal;
import football.model.Team;
import football.repository.GoalRepository;
import football.repository.TeamRepository;
import org.jsoup.Jsoup;
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

    @PostConstruct
    public void parse() throws IOException {

        teamRepository.save(Team.builder()
            .championship(Championship.LA)
            .name("test")
            .build());

        String url = "http://d.myscore.com.ua/x/feed/d_su_Ae9H9qT0_ru_1"; // основная инфа
        // String url = "http://d.myscore.com.ua/x/feed/d_st_Ae9H9qT0_ru_1"; // статистика
        // String url = "http://d.myscore.com.ua/x/feed/d_od_Ae9H9qT0_ru_1_eu";
        Document document = Jsoup.connect(url)
                                 .header("X-Fsign", "SW9D1eZo").get();

        Element table = document.getElementById("parts");


        Elements allRows = table.select("tr");
        int secondTimeIndex = table.select("tr .h-part").get(1).parent().siblingIndex();

        List<Element> firstPeriodRows = allRows.subList(0, secondTimeIndex);
        List<Element> secondPeriodRows = allRows.subList(secondTimeIndex, allRows.size());


        MatchParser.Dto dto = MatchParser.parseGeneralInfo(table.select("tr td.fl"));

    }
}
