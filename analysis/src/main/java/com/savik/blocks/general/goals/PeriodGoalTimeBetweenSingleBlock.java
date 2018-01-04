package com.savik.blocks.general.goals;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodGoalTimeBetween;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGoalTimeBetweenSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGoalTimeBetweenSingleBlock(int from, int to, ContainerType type) {
        super(new PeriodGoalTimeBetween(from, to), type);
    }

    public PeriodGoalTimeBetweenSingleBlock(int from, int to, Function<T, Period> function) {
        super(new PeriodGoalTimeBetween(from, to), function);
    }


}
