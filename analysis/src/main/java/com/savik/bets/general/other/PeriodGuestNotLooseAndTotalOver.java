package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.total.over.PeriodOver;

public class PeriodGuestNotLooseAndTotalOver<T extends Period> extends BiPeriodBet<T> {
    public PeriodGuestNotLooseAndTotalOver(double total) {
        super(
                new PeriodGuestNotLoose<>(),
                new PeriodOver<>(total)
        );
    }
}
