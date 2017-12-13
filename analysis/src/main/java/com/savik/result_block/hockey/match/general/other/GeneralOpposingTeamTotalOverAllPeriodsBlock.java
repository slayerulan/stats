package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.blocks.hockey.goals.match.OpposingTeamTotalOverInAllPeriodsBlock;

import java.util.Arrays;

import static com.savik.ContainerType.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS;
import static com.savik.ContainerType.OVER_0_5;


class GeneralOpposingTeamTotalOverAllPeriodsBlock extends GeneralTeamBetContainer {

    public GeneralOpposingTeamTotalOverAllPeriodsBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new OpposingTeamTotalOverInAllPeriodsBlock(0.5, OVER_0_5)
                ), matchData, OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS
        );
    }
}
