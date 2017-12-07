package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.bets.general.total.over.PeriodOver;

public class PeriodHomeNotLooseAndTotalOver<T extends Period> extends BiPeriodBet<T> {
    public PeriodHomeNotLooseAndTotalOver(double total) {
        super(
                new PeriodHomeNotLoose<>(),
                new PeriodOver<>(total)
        );
    }
}
