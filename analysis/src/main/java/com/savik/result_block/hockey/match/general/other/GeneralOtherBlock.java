package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.MatchData;
import com.savik.blocks.hockey.other.PeriodOpposingTeamFirstScoredAndWinSingleBlock;
import com.savik.blocks.hockey.other.PeriodTeamFirstScoredAndWinSingleBlock;

import java.util.Arrays;

import static com.savik.ContainerType.OTHER;


public class GeneralOtherBlock extends GeneralBetContainer {

    public GeneralOtherBlock(MatchData matchData) {
        super(Arrays.asList(
                new GeneralTotalOverAllPeriodsBlock(),
                new GeneralTotalUnderAllPeriodsBlock(),
                new GeneralAnyWinAndTotalOverBlock(),
                new GeneralAnyWinAndTotalUnderBlock(),
                new GeneralAnyWinAndDiffEqualsBlock(),
                new GeneralFirstGoalBeforeBlock(),
                new GeneralLastGoalAfterBlock(),
                new GeneralTeamWinAndTotalOverBlock(matchData),
                new GeneralTeamWinAndTotalUnderBlock(matchData),
                new GeneralTeamNotLooseAndTotalOverBlock(matchData),
                new GeneralTeamNotLooseAndTotalUnderBlock(matchData),
                new GeneralOpposingTeamWinAndTotalOverBlock(matchData),
                new GeneralOpposingTeamWinAndTotalUnderBlock(matchData),
                new GeneralOpposingTeamNotLooseAndTotalOverBlock(matchData),
                new GeneralOpposingTeamNotLooseAndTotalUnderBlock(matchData),
                new GeneralTeamTotalOverAllPeriodsBlock(matchData),
                new GeneralOpposingTeamTotalOverAllPeriodsBlock(matchData),
                new GeneralTeamWinAtLeastNPeriodsBlock(matchData),
                new GeneralOpposingTeamWinAtLeastNPeriodsBlock(matchData),
                new GeneralDrawInAtLeastNPeriodsBlock(),
                new GeneralMostEffectivePeriodTotalOverBlock(),
                new PeriodTeamFirstScoredAndWinSingleBlock(matchData, ContainerType.TEAM_FIRST_SCORED_AND_WIN),
                new PeriodOpposingTeamFirstScoredAndWinSingleBlock(matchData, ContainerType.OPPOSING_TEAM_FIRST_SCORED_AND_WIN)
        ), OTHER);
    }
}
