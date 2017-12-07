package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.blocks.general.result.TeamWinAtLeastNPeriodsBlock;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamWinAtLeastNPeriodsBlock extends GeneralTeamBetContainer {

    public GeneralTeamWinAtLeastNPeriodsBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new TeamWinAtLeastNPeriodsBlock(1, NUMBER_1),
                        new TeamWinAtLeastNPeriodsBlock(2, NUMBER_2)
                ), matchData, TEAM_WIN_AT_LEAST_N_PERIODS
        );
    }
}
