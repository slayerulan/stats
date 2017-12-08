package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;

import java.util.function.Function;

public class PeriodTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTotalOverPossibleBet(Function<T, Period> function, double amount) {
        super(new PeriodOverSingleBlock<>(amount, function), new PeriodOverSingleBlock<>(amount, function));
    }
}
