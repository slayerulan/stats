package com.savik.bets.general.goals;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.goals.PeriodFirstGoalTimeBeforeSingleBlock;

import java.util.function.Function;

public class PeriodFirstGoalBeforePossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodFirstGoalBeforePossibleBet(Function<T, Period> function, int before) {
        super(
                new PeriodFirstGoalTimeBeforeSingleBlock<>(before, function),
                new PeriodFirstGoalTimeBeforeSingleBlock<>(before, function)
        );
    }
}
