package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralTeamBetContainer;
import com.savik.MatchData;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.hockey.result.WinAtLeastNPeriods;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamWinAtLeastNPeriodsBlock extends GeneralTeamBetContainer {

    public GeneralOpposingTeamWinAtLeastNPeriodsBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new GeneralTeamBetContainer<HockeyMatch>(
                                new WinAtLeastNPeriods(1, new PeriodGuestWinner()),
                                new WinAtLeastNPeriods(1, new PeriodHomeWinner()),
                                NUMBER_1
                        ),
                        new GeneralTeamBetContainer<HockeyMatch>(
                                new WinAtLeastNPeriods(2, new PeriodGuestWinner()),
                                new WinAtLeastNPeriods(2, new PeriodHomeWinner()),
                                NUMBER_2
                        )
                ), matchData, OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS
        );
    }
}
