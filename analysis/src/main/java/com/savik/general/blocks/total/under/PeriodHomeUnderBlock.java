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
public class PeriodHomeUnderBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodHomeUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodHomeUnderSingleBlock(0.5),
                new PeriodHomeUnderSingleBlock(1.5),
                new PeriodHomeUnderSingleBlock(2.5),
                new PeriodHomeUnderSingleBlock(3.5),
                new PeriodHomeUnderSingleBlock(4.5)
        ), function);
    }


}
