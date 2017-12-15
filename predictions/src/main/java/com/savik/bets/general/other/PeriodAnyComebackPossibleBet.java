package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.other.PeriodAnyComebackSingleBlock;

import java.util.function.Function;

public class PeriodAnyComebackPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodAnyComebackPossibleBet(Function<T, Period> function) {
        super(
                new PeriodAnyComebackSingleBlock<>(function),
                new PeriodAnyComebackSingleBlock<>(function)
        );
    }
}
