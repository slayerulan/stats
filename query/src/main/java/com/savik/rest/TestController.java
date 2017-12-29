package com.savik.rest;

import com.savik.*;
import com.savik.blocks.hockey.match.general.PossibleBetsBlock;
import com.savik.coeffs.hockey.CoeffBlock;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.filters.HockeyMatchFilter;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.hockey.coeffs.HockeyCoeffsMatchParser;
import com.savik.parser.utils.CoeffTransformer;
import com.savik.repository.CoeffRepository;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.savik.hockey.specifications.HockeyMatchSpec.*;

@RestController
@RequestMapping("/stats")
public class TestController {

    @Autowired
    FootballMatchRepository footballMatchRepository;


    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyCoeffsMatchParser hockeyCoeffsMatchParser;

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

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

    @GetMapping("/bets/all")
    public PossibleBetResultContainer possibleBetsAll(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        HockeyTeam homeTeam = futureMatch.getHomeTeam();
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(homeTeam.getId())
        );


        HockeyTeam guestTeam = futureMatch.getGuestTeam();
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasTeam(guestTeam.getId())
        );

        PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        CoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);

        PossibleBetResultContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }

    @GetMapping("/bets/home")
    public PossibleBetResultContainer possibleBetsHome(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        HockeyTeam homeTeam = futureMatch.getHomeTeam();
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasHomeTeam(homeTeam.getId())
        );


        HockeyTeam guestTeam = futureMatch.getGuestTeam();
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasGuestTeam(guestTeam.getId())
        );

        PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        CoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);

        PossibleBetResultContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }

    @GetMapping("/stats/home")
    public PossibleBetsBlock statsHome(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        HockeyTeam homeTeam = futureMatch.getHomeTeam();
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasHomeTeam(homeTeam.getId())
        );


        HockeyTeam guestTeam = futureMatch.getGuestTeam();
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasGuestTeam(guestTeam.getId())
        );

        PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        return possibleBetsBlock;
    }

    @Autowired
    CoeffRepository coeffRepository;

    @GetMapping("/bets/test")
    public List<CoeffEntry> test(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());
        CoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);
        List<CoeffEntry> migrate = CoeffTransformer.transformBlockToEntryWithoutAverageCoeffs(coeffBlock, hockeyMatchFilter.getMyscoreCode());
        coeffRepository.save(migrate);
        return migrate;
    }

    @GetMapping("/bets/test2")
    public PossibleBetResultContainer test2(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        HockeyMatch swxvjTjN = hockeyMatchRepository.findByMyscoreCode("SWXVJTjN");

        HockeyTeam homeTeam = futureMatch.getHomeTeam();
        MatchData homeMatchData = new MatchData(homeTeam);
        List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(
                hasHomeTeam(homeTeam.getId())
        );


        HockeyTeam guestTeam = futureMatch.getGuestTeam();
        MatchData guestMatchData = new MatchData(guestTeam);
        List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(
                hasGuestTeam(guestTeam.getId())
        );

        PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        List<CoeffEntry> coeffEntries = coeffRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());
        CoeffContainer coeffContainer = CoeffTransformer.transformEntryToBlock(coeffEntries);

        PossibleBetResultContainer resultContainer = CoefficientsAnalyzer.analyze(coeffContainer, possibleBetsBlock);
        return resultContainer;
    }





}
