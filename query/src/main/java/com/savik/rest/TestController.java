package com.savik.rest;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.filters.HockeyMatchFilter;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.hockey.specifications.HockeyMatchSpec;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.savik.hockey.specifications.HockeyMatchSpec.hasHomeTeam;
import static com.savik.hockey.specifications.HockeyMatchSpec.hasTeam;

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
    public GeneralBetContainer getShortCard(HockeyMatchFilter hockeyMatchFilter) {
        HockeyTeam team = hockeyTeamRepository.findOne(hockeyMatchFilter.getHomeId());
        MatchData matchData = new MatchData(team);


        List<HockeyMatch> all = hockeyMatchRepository.findAll(
                hasTeam(hockeyMatchFilter.getHomeId())
        );
        GeneralBlock generalBlock = new GeneralBlock(ContainerType.GENERAL, matchData);
        all.forEach(generalBlock::check);


        List<HockeyMatch> home = hockeyMatchRepository.findAll(
                hasHomeTeam(hockeyMatchFilter.getHomeId())
        );
        GeneralBlock homeBlock = new GeneralBlock(ContainerType.HOME, matchData);
        home.forEach(homeBlock::check);


        return new GeneralBetContainer(
                Arrays.asList(generalBlock, homeBlock), ContainerType.ROOT
        );
    }
}
