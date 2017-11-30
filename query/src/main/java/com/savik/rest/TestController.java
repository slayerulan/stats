package com.savik.rest;

import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.result_block.hockey.match.ResultBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class TestController {

    @Autowired
    FootballMatchRepository footballMatchRepository;


    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @GetMapping
    public GeneralBetContainer getShortCard() {
        HockeyTeam team = hockeyTeamRepository.findOneByNameAndChampionship("Колорадо", HockeyChampionship.NHL);
        MatchData matchData = new MatchData(team);
        List<HockeyMatch> all = hockeyMatchRepository.findAll();
        ResultBlock homeBlock = new ResultBlock(matchData);
        all.forEach(homeBlock::check);
        return homeBlock;
    }
}
