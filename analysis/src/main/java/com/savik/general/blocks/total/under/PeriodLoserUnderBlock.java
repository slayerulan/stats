package com.savik.general.blocks.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserUnderBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodLoserUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodLoserUnderSingleBlock(0.5),
                new PeriodLoserUnderSingleBlock(1.5),
                new PeriodLoserUnderSingleBlock(2.5),
                new PeriodLoserUnderSingleBlock(3.5),
                new PeriodLoserUnderSingleBlock(4.5)
        ), function);
    }


}
