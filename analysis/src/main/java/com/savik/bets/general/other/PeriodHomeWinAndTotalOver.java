package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;

public class PeriodHomeWinAndTotalOver<T extends Period> extends BiPeriodBet<T> {
    public PeriodHomeWinAndTotalOver(double total) {
        super(
                new PeriodHomeWinner<>(),
                new PeriodOver<>(total)
        );
    }
}
