package com.savik.parser;

import com.savik.parser.football.FootballFutureMatchesParser;
import com.savik.parser.football.FootballParser;
import com.savik.parser.hockey.HockeyFutureMatchesParser;
import com.savik.parser.hockey.HockeyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Savushkin Yauheni
 * @since 27.04.2017
 */
@Service
public class Parser {

    @Autowired
    FootballParser footballParser;

    @Autowired
    HockeyParser hockeyParser;

    @Autowired
    FutureMatchesParser futureMatchesParser;

    @Autowired
    FootballFutureMatchesParser footballFutureMatchesParser;


    @Autowired
    HockeyFutureMatchesParser hockeyFutureMatchesParser;



    @PostConstruct
    public void parse() {
        hockeyFutureMatchesParser.parse();
       //hockeyParser.parse();
    }
}
