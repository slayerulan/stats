package com.savik.result_block.hockey.match.general.other;

import com.savik.BiPeriodBet;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.under.PeriodUnder;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyPeriod;

import java.util.Arrays;

import static com.savik.ContainerType.TEAM_WIN_AND_TOTAL_UNDER;
import static com.savik.ContainerType.UNDER_5_5;


class GeneralTeamWinAndTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralTeamWinAndTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodHomeWinner(),
                                        new PeriodUnder(5.5)
                                ),
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodGuestWinner(),
                                        new PeriodUnder(5.5)
                                ),
                                UNDER_5_5
                        )
                ), HockeyMatch.MATCH, matchData, TEAM_WIN_AND_TOTAL_UNDER
        );
    }
}
