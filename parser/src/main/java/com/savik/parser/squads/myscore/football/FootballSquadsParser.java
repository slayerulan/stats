package com.savik.parser.squads.myscore.football;

import com.savik.football.model.FootballFutureMatch;
import com.savik.football.repository.FootballFutureMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballSquadsParser {

    @Autowired
    FootballFutureMatchRepository matchRepository;

    @Autowired
    FootballTeamSquadParser footballTeamSquadParser;


    public void parse() {

        List<FootballFutureMatch> matches = matchRepository.findAll();
        for (FootballFutureMatch match : matches) {
            footballTeamSquadParser.parse(match);
        }

    }

}
