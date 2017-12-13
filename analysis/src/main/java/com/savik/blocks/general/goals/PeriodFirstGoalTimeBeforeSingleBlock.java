package com.savik.blocks.general.goals;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodFirstGoalTimeBefore;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFirstGoalTimeBeforeSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodFirstGoalTimeBeforeSingleBlock(int amount, ContainerType type) {
        super(new PeriodFirstGoalTimeBefore(amount), type);
    }

    public PeriodFirstGoalTimeBeforeSingleBlock(int amount, Function<T, Period> function) {
        super(new PeriodFirstGoalTimeBefore(amount), function);
    }


}
