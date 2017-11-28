package com.savik.football.blocks.total.under;

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
public class FirstPeriodUnderBlock<T extends Match> extends PeriodBetContainer<T> {

    public FirstPeriodUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodUnderSingleBlock(0.5),
                new PeriodUnderSingleBlock(1.5),
                new PeriodUnderSingleBlock(2.5),
                new PeriodUnderSingleBlock(3.5),
                new PeriodUnderSingleBlock(4.5)
        ), function);
    }


}
