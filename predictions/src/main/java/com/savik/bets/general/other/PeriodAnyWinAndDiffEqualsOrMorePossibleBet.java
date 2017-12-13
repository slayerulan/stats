package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodAnyWinAndDiffEqualsOrMoreBlock;

import java.util.function.Function;

public class PeriodAnyWinAndDiffEqualsOrMorePossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodAnyWinAndDiffEqualsOrMorePossibleBet(Function<T, Period> function, int diff) {
        super(
                new PeriodAnyWinAndDiffEqualsOrMoreBlock<>(diff, function),
                new PeriodAnyWinAndDiffEqualsOrMoreBlock<>(diff, function)
        );
    }
}
