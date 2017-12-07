package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.blocks.hockey.goals.match.TeamTotalOverInAllPeriodsBlock;

import java.util.Arrays;

import static com.savik.ContainerType.OVER_0_5;
import static com.savik.ContainerType.TEAM_TOTAL_OVER_ALL_PERIODS;


class GeneralTeamTotalOverAllPeriodsBlock extends GeneralTeamBetContainer {

    public GeneralTeamTotalOverAllPeriodsBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new TeamTotalOverInAllPeriodsBlock(0.5, OVER_0_5)
                ), matchData, TEAM_TOTAL_OVER_ALL_PERIODS
        );
    }
}
