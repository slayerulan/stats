package com.savik.blocks.general.goals;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodLastGoalTimeAfter;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLastGoalTimeAfterSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodLastGoalTimeAfterSingleBlock(double amount, ContainerType type) {
        super(new PeriodLastGoalTimeAfter(amount), type);
    }

    public PeriodLastGoalTimeAfterSingleBlock(int amount, Function<T, Period> function) {
        super(new PeriodLastGoalTimeAfter(amount), function);
    }


}
