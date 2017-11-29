package com.savik.general.blocks.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestOverBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGuestOverBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodGuestOverSingleBlock<T>(0.5),
                new PeriodGuestOverSingleBlock<T>(1.5),
                new PeriodGuestOverSingleBlock<T>(2.5),
                new PeriodGuestOverSingleBlock<T>(3.5),
                new PeriodGuestOverSingleBlock<T>(4.5)
        ), function);
    }


}
