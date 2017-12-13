package com.savik.blocks.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class PossibleBetsOtherBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsOtherBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new TotalOverInAllPeriodsPossibleBetBlock(),
                new TotalUnderInAllPeriodsPossibleBetBlock(),
                new PeriodAnyWinAndTotalOverPossibleBetBlock(),
                new PeriodAnyWinAndTotalUnderPossibleBetBlock(),
                new PeriodAnyWinAndDiffEqualsPossibleBetBlock(),
                new PeriodFirstGoalBeforePossibleBetBlock(),
                new PeriodLastGoalAfterPossibleBetBlock(),
                new PeriodTeamWinAndTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodTeamWinAndTotalUnderPossibleBetBlock(homeMatchData, guestMatchData),



                new PeriodTeamNotLooseAndTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodTeamNotLooseAndTotalUnderPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamWinAndTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamWinAndTotalUnderPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamNotLooseAndTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new PeriodOpposingTeamNotLooseAndTotalUnderPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamTotalOverInAllPeriodsPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamTotalOverInAllPeriodsPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamWinAtLeastNPeriodsPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamWinAtLeastNPeriodsPossibleBetBlock(homeMatchData, guestMatchData),
                new DrawAtLeastNPeriodsPossibleBetBlock(),
                new MostEffectivePeriodTotalOverPossibleBetBlock(),
                new TeamFirstScoredAndWinPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamFirstScoredAndWinPossibleBetBlock(homeMatchData, guestMatchData)
        ), ContainerType.OTHER);
    }
}
