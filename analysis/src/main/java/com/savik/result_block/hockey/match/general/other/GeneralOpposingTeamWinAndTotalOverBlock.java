package com.savik.result_block.hockey.match.general.other;

import com.savik.BiPeriodBet;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyPeriod;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamWinAndTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamWinAndTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodGuestWinner(),
                                        new PeriodOver(4.5)
                                ),
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodHomeWinner(),
                                        new PeriodOver(4.5)
                                ),
                                OVER_4_5
                        ),
                        new PeriodTeamBetContainer<HockeyMatch>(
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodGuestWinner(),
                                        new PeriodOver(5.5)
                                ),
                                new BiPeriodBet<HockeyPeriod>(
                                        new PeriodHomeWinner(),
                                        new PeriodOver(5.5)
                                ),
                                OVER_5_5
                        )
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_WIN_AND_TOTAL_OVER
        );
    }
}
