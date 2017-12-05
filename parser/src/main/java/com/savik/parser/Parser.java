package com.savik.parser;

import javax.annotation.PostConstruct;

import com.savik.parser.football.FootballFutureMatchesParser;
import com.savik.parser.football.FootballParser;
import com.savik.parser.hockey.HockeyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @PostConstruct
    public void parse() {
        //footballFutureMatchesParser.parse();
       //hockeyParser.parse();
    }
}
