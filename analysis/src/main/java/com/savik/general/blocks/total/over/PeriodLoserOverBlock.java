package com.savik.general.blocks.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserOverBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodLoserOverBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodLoserOverSingleBlock(0.5),
                new PeriodLoserOverSingleBlock(1.5),
                new PeriodLoserOverSingleBlock(2.5),
                new PeriodLoserOverSingleBlock(3.5),
                new PeriodLoserOverSingleBlock(4.5)
        ), function);
    }


}
