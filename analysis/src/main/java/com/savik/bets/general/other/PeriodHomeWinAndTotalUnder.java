package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.bets.general.total.under.PeriodUnder;

public class PeriodHomeWinAndTotalUnder<T extends Period> extends BiPeriodBet<T> {
    public PeriodHomeWinAndTotalUnder(double total) {
        super(
                new PeriodHomeWinner<>(),
                new PeriodUnder<>(total)
        );
    }
}
