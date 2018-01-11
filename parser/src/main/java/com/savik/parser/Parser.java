package com.savik.parser;

import com.savik.parser.coeffs.x1stavka.football.Football1xstavkaCoeffsParser;
import com.savik.parser.coeffs.x1stavka.hockey.Hockey1xstavkaCoeffsParser;
import com.savik.parser.matches.myscore.football.FootballFutureMatchesParser;
import com.savik.parser.matches.myscore.football.FootballParser;
import com.savik.parser.matches.myscore.hockey.HockeyFutureMatchesParser;
import com.savik.parser.matches.myscore.hockey.HockeyParser;
import com.savik.parser.matches.myscore.snooker.SnookerParser;
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
    Football1xstavkaCoeffsParser football1xstavkaCoeffsParser;

    @Autowired
    SnookerParser snookerParser;


    @PostConstruct
    public void parse() throws Exception {
        //ªhockey1xstavkaCoeffsParser.parse();
        //hockeyFutureMatchesParser.parse();
        //hockeyParser.parse();
        //footballParser.parse();
        //football1xstavkaCoeffsParser.parse();
        //footballFutureMatchesParser.parse();


        //snookerParser.parse();
    }
}
