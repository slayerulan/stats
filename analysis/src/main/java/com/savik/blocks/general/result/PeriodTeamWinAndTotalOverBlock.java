package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.hockey.model.HockeyPeriod;

import java.util.function.Function;


public class PeriodTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodHomeNotLoose<>(),
                        new PeriodOver<>(total)
                ),
                new BiPeriodBet<HockeyPeriod>(
                        new PeriodGuestNotLoose<>(),
                        new PeriodOver<>(total)
                ),
                type
        );
    }


}
