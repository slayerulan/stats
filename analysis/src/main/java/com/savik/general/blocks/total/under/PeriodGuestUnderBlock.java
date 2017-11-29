package com.savik.general.blocks.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestUnderBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGuestUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodGuestUnderSingleBlock(0.5),
                new PeriodGuestUnderSingleBlock(1.5),
                new PeriodGuestUnderSingleBlock(2.5),
                new PeriodGuestUnderSingleBlock(3.5),
                new PeriodGuestUnderSingleBlock(4.5)
        ), function);
    }


}
