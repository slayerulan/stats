package com.savik.football.blocks.goals;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFirstGoalTimeBeforeBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodFirstGoalTimeBeforeBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodFirstGoalTimeBeforeSingleBlock(20),
                new PeriodFirstGoalTimeBeforeSingleBlock(30)
        ), function);
    }


}
