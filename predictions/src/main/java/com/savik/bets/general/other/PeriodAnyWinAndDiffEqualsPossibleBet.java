package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodAnyWinAndDiffEqualsBlock;

import java.util.function.Function;

public class PeriodAnyWinAndDiffEqualsPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodAnyWinAndDiffEqualsPossibleBet(Function<T, Period> function, int diff) {
        super(
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function),
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function)
        );
    }
}
