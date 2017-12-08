package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;

import java.util.function.Function;

public class PeriodAnyWinAndTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodAnyWinAndTotalOverPossibleBet(Function<T, Period> function, double amount) {
        super(
                new PeriodWinAndOverSingleBlock<>(amount, new PeriodAnyWinner(), function),
                new PeriodWinAndOverSingleBlock<>(amount, new PeriodAnyWinner(), function)
        );
    }
}
