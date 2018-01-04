package com.savik.bets.general.goals;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.goals.PeriodGoalTimeBetweenSingleBlock;

import java.util.function.Function;

public class PeriodGoaBetweenPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodGoaBetweenPossibleBet(Function<T, Period> function, int from, int to) {
        super(
                new PeriodGoalTimeBetweenSingleBlock<>(from, to, function),
                new PeriodGoalTimeBetweenSingleBlock<>(from, to, function)
        );
    }
}
