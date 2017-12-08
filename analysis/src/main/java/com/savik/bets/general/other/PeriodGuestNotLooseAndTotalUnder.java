package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.total.under.PeriodUnder;

public class PeriodGuestNotLooseAndTotalUnder<T extends Period> extends BiPeriodBet<T> {
    public PeriodGuestNotLooseAndTotalUnder(double total) {
        super(
                new PeriodGuestNotLoose<>(),
                new PeriodUnder<>(total)
        );
    }
}
