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
import com.savik.repository.CoeffRepository;
import com.savik.result_block.hockey.match.general.GeneralBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
        List<CoeffEntry> gx2euw5b = coeffRepository.findByMyscoreCode("Gx2euw5b");
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        CoeffBlock coeffBlock = hockeyCoeffsMatchParser.parse(futureMatch);
        List<CoeffEntry> migrate = transformBlockToEntry(coeffBlock, "");
        Iterator<CoeffEntry> iterator = migrate.iterator();
        while (iterator.hasNext()) {
            CoeffEntry coeffEntry = iterator.next();
            if (coeffEntry.getCoeff() == null || coeffEntry.getCoeff().isAverageCoeff()) {
                iterator.remove();
            }
            coeffEntry.setMyscoreCode(hockeyMatchFilter.getMyscoreCode());

        }
        coeffRepository.save(migrate);
        return migrate;
    }

    @GetMapping("/bets/test2")
    public PossibleBetResultContainer test2(HockeyMatchFilter hockeyMatchFilter) {
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

        List<CoeffEntry> coeffEntries = coeffRepository.findByMyscoreCode(hockeyMatchFilter.getMyscoreCode());
        CoeffContainer coeffContainer = transformEntryToBlock(coeffEntries);

        PossibleBetResultContainer resultContainer = CoefficientsAnalyzer.analyze(coeffContainer, possibleBetsBlock);
        return resultContainer;
    }

    public List<CoeffEntry> transformBlockToEntry(CoeffContainer coeffBlock, String parentPath) {
        if (coeffBlock.getLeaf()) {
            return Arrays.asList(
                    new CoeffEntry(
                            coeffBlock.getCoeff(),
                            true,
                            String.format("%s.%d", parentPath, coeffBlock.getType().ordinal())
                    )
            );
        } else {
            List<? extends CoeffContainer> childrenBlocks = coeffBlock.getChildrenBlocks();
            List<CoeffEntry> childBlocks = new ArrayList<>();
            String path = parentPath.isEmpty() ? String.valueOf(coeffBlock.getType().ordinal()) :
                    String.format("%s.%d", parentPath, coeffBlock.getType().ordinal());
            childBlocks.add(
                    new CoeffEntry(
                            coeffBlock.getCoeff(), false, path
                    )
            );
            for (CoeffContainer childBlock : childrenBlocks) {
                List<CoeffEntry> coeffEntries = transformBlockToEntry(childBlock, path);
                childBlocks.addAll(coeffEntries);
            }
            return childBlocks;
        }
    }

    public CoeffContainer transformEntryToBlock(List<CoeffEntry> coeffEntries) {
        CoeffContainer root = new CoeffContainer(new ArrayList<>(), ContainerType.ROOT);
        for (CoeffEntry coeffEntry : coeffEntries) {

            CoeffContainer current = root;
            String path = coeffEntry.getPath();
            List<String> types = Arrays.asList(path.split("\\."));
            for (int i = 1; i < types.size(); i++) {
                String ordinal = types.get(i);
                ContainerType containerType = ContainerType.values()[Integer.valueOf(ordinal)];
                CoeffContainer temp = current.findByTypeInFirstLevel(containerType);
                if (temp == null) {
                    if (i == types.size() - 1) {
                        temp = new CoeffContainer(coeffEntry.getCoeff(), containerType);
                    } else {
                        temp = new CoeffContainer(new ArrayList<>(), containerType);
                    }
                    current.getChildrenBlocks().add(temp);
                }
                current = temp;
            }
        }
        return root;
    }

}
