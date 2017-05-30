package com.savik.parser;

import javax.annotation.PostConstruct;

import com.savik.parser.football.FootballParser;
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
    FutureMatchesParser futureMatchesParser;



    @PostConstruct
    public void parse() {
        futureMatchesParser.parse();
    }
}
