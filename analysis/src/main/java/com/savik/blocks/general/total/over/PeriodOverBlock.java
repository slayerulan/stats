package com.savik.blocks.general.total.over;

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
public class PeriodOverBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodOverBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodOverSingleBlock(0.5, OVER_0_5),
                new PeriodOverSingleBlock(1.5, OVER_1_5),
                new PeriodOverSingleBlock(2.5, OVER_2_5),
                new PeriodOverSingleBlock(3.5, OVER_3_5),
                new PeriodOverSingleBlock(4.5, OVER_4_5)
        ), function);
    }


}
