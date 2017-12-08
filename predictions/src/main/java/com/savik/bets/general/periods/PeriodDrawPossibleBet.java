package com.savik.bets.general.periods;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodDrawBlock;

import java.util.function.Function;

public class PeriodDrawPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodDrawPossibleBet(Function<T, Period> function) {
        super(new PeriodDrawBlock<>(function), new PeriodDrawBlock<>(function));
    }
}
