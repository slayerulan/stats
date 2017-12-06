package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralBetContainer;
import com.savik.MatchData;

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
                new GeneralOpposingTeamWinAndTotalOverBlock(matchData),
                new GeneralTeamWinAndTotalUnderBlock(matchData),
                new GeneralTeamWinAtLeastNPeriodsBlock(matchData),
                new GeneralOpposingTeamWinAtLeastNPeriodsBlock(matchData)
        ), OTHER);
    }
}
