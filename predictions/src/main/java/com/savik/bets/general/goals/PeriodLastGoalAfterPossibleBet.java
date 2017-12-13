package com.savik.bets.general.goals;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.goals.PeriodLastGoalTimeAfterSingleBlock;

import java.util.function.Function;

public class PeriodLastGoalAfterPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodLastGoalAfterPossibleBet(Function<T, Period> function, int before) {
        super(
                new PeriodLastGoalTimeAfterSingleBlock<>(before, function),
                new PeriodLastGoalTimeAfterSingleBlock<>(before, function)
        );
    }
}
