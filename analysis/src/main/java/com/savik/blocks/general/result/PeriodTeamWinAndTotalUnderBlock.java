package com.savik.blocks.general.result;

import com.savik.BiPeriodBet;
import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.bets.general.total.under.PeriodUnder;
import com.savik.hockey.model.HockeyPeriod;


public class PeriodTeamWinAndTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamWinAndTotalUnderBlock(double total, ContainerType type) {
        super(
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodHomeWinner<>(),
                        new PeriodUnder(total)
                ),
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodGuestWinner<>(),
                        new PeriodUnder<>(total)
                ),
                type
        );
    }


}
