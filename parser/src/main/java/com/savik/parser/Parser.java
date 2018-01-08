package com.savik.parser;

import com.savik.parser.football.FootballFutureMatchesParser;
import com.savik.parser.football.FootballParser;
import com.savik.parser.hockey.coeffs.Hockey1xstavkaCoeffsParser;
import com.savik.parser.hockey.matches.HockeyFutureMatchesParser;
import com.savik.parser.hockey.matches.HockeyParser;
import com.savik.parser.snooker.matches.SnookerParser;
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

    @Autowired
    Hockey1xstavkaCoeffsParser hockey1xstavkaCoeffsParser;

    @Autowired
    SnookerParser snookerParser;


    @PostConstruct
    public void parse() throws Exception {
        //hockey1xstavkaCoeffsParser.parse();
        //hockeyFutureMatchesParser.parse();
        //hockeyParser.parse();
        //snookerParser.parse();
        //footballParser.parse();
    }
}
