package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodUnderSingleBlock;

import java.util.function.Function;

public class PeriodTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTotalUnderPossibleBet(Function<T, Period> function, double amount) {
        super(new PeriodUnderSingleBlock<>(amount, function), new PeriodUnderSingleBlock<>(amount, function));
    }
}
