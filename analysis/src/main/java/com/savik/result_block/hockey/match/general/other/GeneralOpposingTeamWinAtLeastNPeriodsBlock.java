package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.hockey.result.WinAtLeastNPeriods;
import com.savik.blocks.general.result.OpposingTeamWinAtLeastNPeriodsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamWinAtLeastNPeriodsBlock extends GeneralTeamBetContainer {

    public GeneralOpposingTeamWinAtLeastNPeriodsBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new OpposingTeamWinAtLeastNPeriodsBlock(1, NUMBER_1),
                        new OpposingTeamWinAtLeastNPeriodsBlock(2, NUMBER_2)
                ), matchData, OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS
        );
    }
}
