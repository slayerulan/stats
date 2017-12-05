package com.savik.blocks.general.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;

import java.util.Arrays;
import java.util.function.Function;

import static com.savik.ContainerType.*;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodUnderBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodUnderSingleBlock(0.5, UNDER_0_5),
                new PeriodUnderSingleBlock(1.5, UNDER_1_5),
                new PeriodUnderSingleBlock(2.5, UNDER_2_5),
                new PeriodUnderSingleBlock(3.5, UNDER_3_5),
                new PeriodUnderSingleBlock(4.5, UNDER_4_5)
        ), function);
    }


}
