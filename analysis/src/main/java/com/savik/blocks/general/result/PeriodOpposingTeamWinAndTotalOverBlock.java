package com.savik.blocks.general.result;

import com.savik.BiPeriodBet;
import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.hockey.model.HockeyPeriod;


public class PeriodOpposingTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodGuestWinner<>(),
                        new PeriodOver<>(total)
                ),
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodHomeWinner<>(),
                        new PeriodOver<>(total)
                ),
                type
        );
    }


}
