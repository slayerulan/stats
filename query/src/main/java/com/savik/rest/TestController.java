package com.savik.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.savik.*;
import com.savik.blocks.football.match.FootballPossibleBetsBlock;
import com.savik.blocks.hockey.match.general.HockeyPossibleBetsBlock;
import com.savik.filters.MatchFilter;
import com.savik.football.model.*;
import com.savik.football.repository.*;
import com.savik.football.specifications.FootballMatchSpec;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.hockey.specifications.HockeyMatchSpec;
import com.savik.parser.utils.CoeffTransformer;
import com.savik.repository.CoeffRepository;
import com.savik.result_block.football.match.cards.GeneralCardsTotalOverBlock;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.savik.football.specifications.FootballMatchSpec.hasReferee;
import static com.savik.football.specifications.FootballRefereeSpec.hasName;
import static com.savik.football.specifications.FootballTeamSquadSpec.hasTeam;


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
    FootballRefereeRepository footballRefereeRepository;

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    FootballFutureMatchRepository footballFutureMatchRepository;

    @Autowired
    FootballTeamSquadRepository footballTeamSquadRepository;

    @Autowired
    FootballFutureMatchInfoRepository footballFutureMatchInfoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/match/stats")
    public GeneralBetContainer matchStats(MatchFilter matchFilter) {
        HockeyTeam team = hockeyTeamRepository.findOne(matchFilter.getHomeId());
        MatchData matchData = new MatchData(team);


        List<HockeyMatch> all = hockeyMatchRepository.findAll(
                HockeyMatchSpec.hasTeam(matchFilter.getHomeId())
        );
        GeneralBlock generalBlock = new GeneralBlock(ContainerType.GENERAL, matchData);
        all.forEach(generalBlock::check);


        List<HockeyMatch> home = hockeyMatchRepository.findAll(
                HockeyMatchSpec.hasHomeTeam(matchFilter.getHomeId())
        );
        GeneralBlock homeBlock = new GeneralBlock(ContainerType.HOME, matchData);
        home.forEach(homeBlock::check);


        return new GeneralBetContainer(
                Arrays.asList(generalBlock, homeBlock), ContainerType.ROOT
        );
    }

    @GetMapping("/bets/possible")
    public PossibleBetContainer betsOnlyHomeGuestMatches(MatchFilter matchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(matchFilter.getMyscoreCode());
        PossibleBetContainer hockeyPossibleBetsBlock = new HockeyAnalyzer(matchFilter, futureMatch).getPossibleBetsBlock();
        return hockeyPossibleBetsBlock;
    }

    @Autowired
    CoeffRepository coeffRepository;

    @GetMapping("/bets/proposed")
    public ProposedBetsContainer proposedBets(MatchFilter matchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(matchFilter.getMyscoreCode());
        PossibleBetContainer hockeyPossibleBetsBlock = new HockeyAnalyzer(matchFilter, futureMatch).getPossibleBetsBlock();
        ProposedBetsContainer resultContainer = getProposedBetsContainer(matchFilter.getMyscoreCode(), hockeyPossibleBetsBlock);
        return resultContainer;
    }

    @PostMapping("/bets/referee")
    public BetContainer referee(@RequestBody MatchFilter matchFilter) {
        FootballReferee referee = footballRefereeRepository.findOne(hasName(matchFilter.getRefereeName()));
        List<FootballMatch> byRefereeId = footballMatchRepository.findAll(hasReferee(referee.getId()));
        GeneralCardsTotalOverBlock totalOverBlock = new GeneralCardsTotalOverBlock();
        totalOverBlock.check(byRefereeId);
        return totalOverBlock;
    }

    @GetMapping("/bets/all")
    public void parseAll(MatchFilter matchFilter) throws IOException {
        analyzeHockey(matchFilter);
        analyzeFootball(matchFilter);
    }

    private void analyzeHockey(MatchFilter matchFilter) throws IOException {
        List<HockeyFutureMatch> all = hockeyFutureMatchRepository.findAll();
        for (HockeyFutureMatch futureMatch : all) {

            MatchFilter homeFilter = matchFilter.builder().includeAllMatches(false).size(15).build();
            PossibleBetContainer hockeyPossibleBetsBlock = new HockeyAnalyzer(homeFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainer = getProposedBetsContainer(futureMatch.getMyscoreCode(), hockeyPossibleBetsBlock);
            writeMatchToFile("info/matches/hockey/", "home", futureMatch, resultContainer);


            /*MatchFilter allFilter = matchFilter.builder().includeAllMatches(true).build();
            HockeyPossibleBetsBlock possibleBetsBlockAllMatches = new HockeyAnalyzer(allFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerAllMatches = getProposedBetsContainer(futureMatch.getMyscoreCode(), possibleBetsBlockAllMatches);
            writeMatchToFile("info/matches/", "all", futureMatch, resultContainerAllMatches);*/

            MatchFilter last10Filter = matchFilter.builder().includeAllMatches(false).size(10).build();
            PossibleBetContainer hockeyPossibleBetsBlockLast10Matches = new HockeyAnalyzer(last10Filter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerkLast10Matches = getProposedBetsContainer(futureMatch.getMyscoreCode(), hockeyPossibleBetsBlockLast10Matches);
            writeMatchToFile("info/matches/hockey/", "last10home", futureMatch, resultContainerkLast10Matches);
        }
    }

    private void analyzeFootball(MatchFilter matchFilter) throws IOException {
        List<FootballFutureMatch> all = footballFutureMatchRepository.findAll();
        for (FootballFutureMatch futureMatch : all) {

            MatchFilter homeFilter = matchFilter.builder().includeAllMatches(false).size(15).build();
            PossibleBetContainer hockeyPossibleBetsBlock = new FootballAnalyzer(homeFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainer = getProposedBetsContainer(futureMatch.getMyscoreCode(), hockeyPossibleBetsBlock);
            writeMatchToFile("info/matches/football/", "home", futureMatch, resultContainer);


            MatchFilter allFilter = matchFilter.builder().includeAllMatches(true).build();
            PossibleBetContainer possibleBetsBlockAllMatches = new FootballAnalyzer(allFilter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerAllMatches = getProposedBetsContainer(futureMatch.getMyscoreCode(), possibleBetsBlockAllMatches);
            writeMatchToFile("info/matches/football/", "all", futureMatch, resultContainerAllMatches);

            FootballFutureMatchInfo futureMatchInfo = footballFutureMatchInfoRepository.findByMyscoreCode(futureMatch.getMyscoreCode());
            if (futureMatchInfo != null) {
                FootballTeamSquad homeSquad = footballTeamSquadRepository.findOne(hasTeam(futureMatch.getHomeTeam()));
                FootballTeamSquad guestSquad = footballTeamSquadRepository.findOne(hasTeam(futureMatch.getGuestTeam()));
                futureMatchInfo.setHomeSquad(homeSquad);
                futureMatchInfo.setGuestSquad(guestSquad);
                writeMatchToFile("info/matches/football/", "info", futureMatch, futureMatchInfo);
            }


/*            MatchFilter last10Filter = matchFilter.builder().includeAllMatches(false).size(10).build();
            FootballPossibleBetsBlock hockeyPossibleBetsBlockLast10Matches = new FootballAnalyzer(last10Filter, futureMatch).getPossibleBetsBlock();
            ProposedBetsContainer resultContainerkLast10Matches = getProposedBetsContainer(futureMatch.getMyscoreCode(), hockeyPossibleBetsBlockLast10Matches);
            writeMatchToFile("info/matches/football/", "last10home", futureMatch, resultContainerkLast10Matches);*/
        }
    }

    private void writeMatchToFile(String folderPrefix, String matchPrefix, FutureMatch futureMatch, Object value) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd(HH-mm)");
        File leagueDir2 = new File(folderPrefix + futureMatch.getChampionshipString().toString());
        Files.createDirectories(leagueDir2.toPath());
        File matchFile = new File(leagueDir2,
                String.format(
                        "%s-%s(%s)  %s===%s.json", futureMatch.getDate().format(formatter), futureMatch.getMyscoreCode(),
                        matchPrefix, futureMatch.getHomeTeam().getName(), futureMatch.getGuestTeam().getName()
                )
        );
        objectMapper.writeValue(matchFile, value);
    }

    private ProposedBetsContainer getProposedBetsContainer(String myscoreCode, PossibleBetContainer hockeyPossibleBetsBlock) {
        List<CoeffEntry> coeffEntries = coeffRepository.findByMyscoreCode(myscoreCode);
        CoeffContainer coeffContainer = CoeffTransformer.transformEntryToBlock(coeffEntries);
        ProposedBetsContainer proposedBetsContainer = CoefficientsAnalyzer.analyze(coeffContainer, hockeyPossibleBetsBlock);
        //CoefficientsAnalyzer.clearExceptGoodBets(proposedBetsContainer);
        return proposedBetsContainer;
    }


    class HockeyAnalyzer {

        MatchFilter matchFilter;

        HockeyFutureMatch futureMatch;

        boolean isIncludeAllMatches;

        Integer size;

        HockeyAnalyzer(MatchFilter matchFilter, HockeyFutureMatch futureMatch) {
            this.matchFilter = matchFilter;
            this.futureMatch = futureMatch;
            this.isIncludeAllMatches = matchFilter.isIncludeAllMatches();
            this.size = matchFilter.getSize();
        }

        PossibleBetContainer getPossibleBetsBlock() {
            Specification<HockeyMatch> homeTeamSpec;
            Specification<HockeyMatch> guestTeamSpec;
            HockeyTeam homeTeam = futureMatch.getHomeTeam();
            HockeyTeam guestTeam = futureMatch.getGuestTeam();
            if (isIncludeAllMatches) {
                homeTeamSpec = HockeyMatchSpec.hasTeam(homeTeam.getId());
                guestTeamSpec = HockeyMatchSpec.hasTeam(guestTeam.getId());
            } else {
                homeTeamSpec = HockeyMatchSpec.hasHomeTeam(homeTeam.getId());
                guestTeamSpec = HockeyMatchSpec.hasGuestTeam(guestTeam.getId());
            }

            List<HockeyMatch> homeTeamMatches = hockeyMatchRepository.findAll(homeTeamSpec, size);
            List<HockeyMatch> guestTeamMatches = hockeyMatchRepository.findAll(guestTeamSpec, size);

            MatchData homeMatchData = new MatchData(homeTeam);
            MatchData guestMatchData = new MatchData(guestTeam);
            HockeyPossibleBetsBlock hockeyPossibleBetsBlock = new HockeyPossibleBetsBlock(homeMatchData, guestMatchData);
            hockeyPossibleBetsBlock.check(homeTeamMatches, guestTeamMatches);
            return hockeyPossibleBetsBlock;
        }

    }

    class FootballAnalyzer {

        MatchFilter matchFilter;

        FootballFutureMatch futureMatch;

        boolean isIncludeAllMatches;

        Integer size;

        FootballAnalyzer(MatchFilter matchFilter, FootballFutureMatch futureMatch) {
            this.matchFilter = matchFilter;
            this.futureMatch = futureMatch;
            this.isIncludeAllMatches = matchFilter.isIncludeAllMatches();
            this.size = matchFilter.getSize();
        }

        PossibleBetContainer getPossibleBetsBlock() {
            Specification<FootballMatch> homeTeamSpec;
            Specification<FootballMatch> guestTeamSpec;
            FootballTeam homeTeam = futureMatch.getHomeTeam();
            FootballTeam guestTeam = futureMatch.getGuestTeam();
            if (isIncludeAllMatches) {
                homeTeamSpec = FootballMatchSpec.hasTeam(homeTeam.getId());
                guestTeamSpec = FootballMatchSpec.hasTeam(guestTeam.getId());
            } else {
                homeTeamSpec = FootballMatchSpec.hasHomeTeam(homeTeam.getId());
                guestTeamSpec = FootballMatchSpec.hasGuestTeam(guestTeam.getId());
            }

            List<FootballMatch> homeTeamMatches = footballMatchRepository.findAll(homeTeamSpec, size);
            List<FootballMatch> guestTeamMatches = footballMatchRepository.findAll(guestTeamSpec, size);

            MatchData homeMatchData = new MatchData(homeTeam);
            MatchData guestMatchData = new MatchData(guestTeam);
            FootballPossibleBetsBlock footballPossibleBetsBlock = new FootballPossibleBetsBlock(homeMatchData, guestMatchData);
            footballPossibleBetsBlock.check(homeTeamMatches, guestTeamMatches);
            return footballPossibleBetsBlock;
        }

    }



    /*@GetMapping("/bets/all")
    public ProposedBetsContainer possibleBetsAll(MatchFilter matchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(matchFilter.getMyscoreCode());

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

        HockeyPossibleBetsBlock possibleBetsBlock = new HockeyPossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        HockeyCoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);

        ProposedBetsContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }*/

/*    @GetMapping("/bets/home")
    public ProposedBetsContainer possibleBetsHome(MatchFilter matchFilter) {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(matchFilter.getMyscoreCode());

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

        HockeyPossibleBetsBlock possibleBetsBlock = new HockeyPossibleBetsBlock(homeMatchData, guestMatchData);
        possibleBetsBlock.check(homeTeamMatches, guestTeamMatches);

        HockeyCoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);

        ProposedBetsContainer resultContainer = CoefficientsAnalyzer.analyze(coeffBlock, possibleBetsBlock);

        return resultContainer;
    }*/


}
