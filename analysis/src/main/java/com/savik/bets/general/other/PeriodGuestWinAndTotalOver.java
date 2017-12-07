package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.bets.general.total.over.PeriodOver;

public class PeriodGuestWinAndTotalOver<T extends Period> extends BiPeriodBet<T> {
    public PeriodGuestWinAndTotalOver(double total) {
        super(
                new PeriodGuestWinner<>(),
                new PeriodOver<>(total)
        );
    }
}
