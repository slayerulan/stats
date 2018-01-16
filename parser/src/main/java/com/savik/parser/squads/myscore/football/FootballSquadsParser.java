package com.savik.parser.squads.myscore.football;

import com.savik.football.model.FootballFutureMatch;
import com.savik.football.model.FootballTeamSquad;
import com.savik.football.repository.FootballFutureMatchRepository;
import com.savik.football.repository.FootballTeamSquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.savik.football.specifications.FootballTeamSquadSpec.hasTeam;

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


    @Autowired
    FootballTeamSquadRepository footballTeamSquadRepository;


    public void parse() {

        FootballFutureMatch byMyscoreCode = matchRepository.findByMyscoreCode("0hjYWZ2T");
        //footballTeamSquadParser.parse(byMyscoreCode);
        FootballTeamSquad homeSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getHomeTeam()));
        FootballTeamSquad guestSquadInfo = footballTeamSquadRepository.findOne(hasTeam(byMyscoreCode.getGuestTeam()));

        FutureMatchSquads futureMatchSquads = footballTeamSquadParser.parseTest(byMyscoreCode);

        String a = "";


/*
        List<FootballFutureMatch> matches = matchRepository.findAll();
        for (FootballFutureMatch match : matches) {
            footballTeamSquadParser.parse(match);
        }*/

    }

}
