package com.savik.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.savik.*;
import com.savik.blocks.hockey.match.general.PossibleBetsBlock;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.filters.HockeyMatchFilter;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.utils.CoeffTransformer;
import com.savik.repository.CoeffRepository;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/match/stats")
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

    @GetMapping("/bets/possible")
    public PossibleBetsBlock betsOnlyHomeGuestMatches(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());
        PossibleBetsBlock possibleBetsBlock = new Analyzer(hockeyMatchFilter, futureMatch).getPossibleBetsBlock();
        return possibleBetsBlock;
    }

    @Autowired
    CoeffRepository coeffRepository;

    @GetMapping("/bets/proposed")
    public ProposedBetsContainer proposedBets(HockeyMatchFilter hockeyMatchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        PossibleBetsBlock possibleBetsBlock = new Analyzer(hockeyMatchFilter, futureMatch).getPossibleBetsBlock();
        ProposedBetsContainer resultContainer = getProposedBetsContainer(hockeyMatchFilter.getMyscoreCode(), possibleBetsBlock);
        return resultContainer;
    }

    @GetMapping("/bets/all")
    public void parseAll(HockeyMatchFilter hockeyMatchFilter) throws IOException {
        List<HockeyFutureMatch> all = hockeyFutureMatchRepository.findAll();
        for (HockeyFutureMatch futureMatch : all) {

            HockeyMatchFilter homeFilter = hockeyMatchFilter.builder().includeAllMatches(false).build();
            PossibleBetsBlock possibleBetsBlock = new Analyzer(homeFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainer = getProposedBetsContainer(futureMatch.getMyscoreCode(), possibleBetsBlock);
            writeMatchToFile("info/matches/", "home", futureMatch, resultContainer);


            /*HockeyMatchFilter allFilter = hockeyMatchFilter.builder().includeAllMatches(true).build();
            PossibleBetsBlock possibleBetsBlockAllMatches = new Analyzer(allFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerAllMatches = getProposedBetsContainer(futureMatch.getMyscoreCode(), possibleBetsBlockAllMatches);
            writeMatchToFile("info/matches/", "all", futureMatch, resultContainerAllMatches);*/

            HockeyMatchFilter last10Filter = hockeyMatchFilter.builder().includeAllMatches(false).size(10).build();
            PossibleBetsBlock possibleBetsBlockLast10Matches = new Analyzer(last10Filter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerkLast10Matches = getProposedBetsContainer(futureMatch.getMyscoreCode(), possibleBetsBlockLast10Matches);
            writeMatchToFile("info/matches/", "last10home", futureMatch, resultContainerkLast10Matches);
        }
    }

    private void writeMatchToFile(String folderPrefix, String matchPrefix, HockeyFutureMatch futureMatch, ProposedBetsContainer proposedBets) throws IOException {
        File leagueDir2 = new File(folderPrefix + futureMatch.getChampionship().toString());
        Files.createDirectories(leagueDir2.toPath());
        File matchFile = new File(leagueDir2,
                String.format(
                        "%s-%s(%s)  %s===%s.json", futureMatch.getDate().toString(), futureMatch.getMyscoreCode(),
                        matchPrefix, futureMatch.getHomeTeam().getName(), futureMatch.getGuestTeam().getName()
                )
        );
        objectMapper.writeValue(matchFile, proposedBets);
    }

    private ProposedBetsContainer getProposedBetsContainer(String myscoreCode, PossibleBetsBlock possibleBetsBlock) {
        List<CoeffEntry> coeffEntries = coeffRepository.findByMyscoreCode(myscoreCode);
        CoeffContainer coeffContainer = CoeffTransformer.transformEntryToBlock(coeffEntries);
        ProposedBetsContainer proposedBetsContainer = CoefficientsAnalyzer.analyze(coeffContainer, possibleBetsBlock);
        //CoefficientsAnalyzer.clearExceptGoodBets(proposedBetsContainer);
        return proposedBetsContainer;
    }


    class Analyzer {

        HockeyMatchFilter hockeyMatchFilter;

        HockeyFutureMatch futureMatch;

        boolean isIncludeAllMatches;

        Integer size;

        Analyzer(HockeyMatchFilter hockeyMatchFilter, HockeyFutureMatch futureMatch) {
            this.hockeyMatchFilter = hockeyMatchFilter;
            this.futureMatch = futureMatch;
            this.isIncludeAllMatches = hockeyMatchFilter.isIncludeAllMatches();
            this.size = hockeyMatchFilter.getSize();
        }

        PossibleBetsBlock getPossibleBetsBlock() {
            Specification<HockeyMatch> homeTeamSpec;
            Specification<HockeyMatch> guestTeamSpec;
            HockeyTeam homeTeam = futureMatch.getHomeTeam();
            HockeyTeam guestTeam = futureMatch.getGuestTeam();
            if (isIncludeAllMatches) {
                homeTeamSpec = hasTeam(homeTeam.getId());
                guestTeamSpec = hasTeam(guestTeam.getId());
            } else {
                homeTeamSpec = hasHomeTeam(homeTeam.getId());
                guestTeamSpec = hasGuestTeam(guestTeam.getId());
            }

            List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(homeTeamSpec, size);
            List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(guestTeamSpec, size);

            MatchData homeMatchData = new MatchData(homeTeam);
            MatchData guestMatchData = new MatchData(guestTeam);
            PossibleBetsBlock possibleBetsBlock = new PossibleBetsBlock(homeMatchData, guestMatchData);
            possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);
            return possibleBetsBlock;
        }

    }



    /*@GetMapping("/bets/all")
    public ProposedBetsContainer possibleBetsAll(HockeyMatchFilter hockeyMatchFilter) {
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

        ProposedBetsContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }*/

/*    @GetMapping("/bets/home")
    public ProposedBetsContainer possibleBetsHome(HockeyMatchFilter hockeyMatchFilter) {
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

        ProposedBetsContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }*/


}
