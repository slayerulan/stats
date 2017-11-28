package com.savik.football.blocks.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeOverBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodHomeOverBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodHomeOverSingleBlock<T>(0.5),
                new PeriodHomeOverSingleBlock<T>(1.5),
                new PeriodHomeOverSingleBlock<T>(2.5),
                new PeriodHomeOverSingleBlock<T>(3.5),
                new PeriodHomeOverSingleBlock<T>(4.5)
        ), function);
    }


}
