package com.savik.bets.general.other;


import com.savik.BiPeriodBet;
import com.savik.Period;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.bets.general.total.under.PeriodUnder;

public class PeriodHomeNotLooseAndTotalUnder<T extends Period> extends BiPeriodBet<T> {
    public PeriodHomeNotLooseAndTotalUnder(double total) {
        super(
                new PeriodHomeNotLoose<>(),
                new PeriodUnder<>(total)
        );
    }
}
