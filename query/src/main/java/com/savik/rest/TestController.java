package com.savik.rest;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.hockey.match.general.other.PossibleBetsOtherBlock;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.filters.HockeyMatchFilter;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
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

    @GetMapping("/match")
    public GeneralBetContainer matchStats(HockeyMatchFilter hockeyMatchFilter) {
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

    @GetMapping("/bets")
    public PossibleBetContainer possibleBets(HockeyMatchFilter hockeyMatchFilter) {
        HockeyTeam homeTeam = hockeyTeamRepository.findOne(hockeyMatchFilter.getHomeId());
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(hockeyMatchFilter.getHomeId())
        );


        HockeyTeam guestTeam = hockeyTeamRepository.findOne(hockeyMatchFilter.getGuestId());
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(hockeyMatchFilter.getGuestId())
        );

        //PossibleBetsHandicapBlock possibleBetsBlock = new PossibleBetsHandicapBlock(homeMatchData, guestMatchData);
        //PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        //PossibleBetsPeriodsBlock possibleBetsBlock = new PossibleBetsPeriodsBlock(homeMatchData, guestMatchData);
        PossibleBetsOtherBlock possibleBetsBlock = new PossibleBetsOtherBlock(homeMatchData, guestMatchData);
        //PossibleBetsTotalBlock possibleBetsBlock = new PossibleBetsTotalBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        return possibleBetsBlock;

    }
}
