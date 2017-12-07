package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.bets.general.total.under.PeriodUnder;

public class PeriodGuestWinAndTotalUnder<T extends Period> extends BiPeriodBet<T> {
    public PeriodGuestWinAndTotalUnder(double total) {
        super(
                new PeriodGuestWinner<>(),
                new PeriodUnder<>(total)
        );
    }
}
