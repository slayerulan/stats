package com.savik.bets.general.periods;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodAnyWinnerBlock;

import java.util.function.Function;

public class PeriodAnyWinnerPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodAnyWinnerPossibleBet(Function<T, Period> function) {
        super(new PeriodAnyWinnerBlock<>(function), new PeriodAnyWinnerBlock<>(function));
    }
}
