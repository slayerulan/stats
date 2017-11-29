package com.savik.blocks.general.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodUnderBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodUnderSingleBlock(0.5),
                new PeriodUnderSingleBlock(1.5),
                new PeriodUnderSingleBlock(2.5),
                new PeriodUnderSingleBlock(3.5),
                new PeriodUnderSingleBlock(4.5)
        ), function);
    }


}
