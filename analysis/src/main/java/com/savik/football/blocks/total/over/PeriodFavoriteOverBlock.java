package com.savik.football.blocks.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteOverBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteOverBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodFavoriteOverSingleBlock(0.5),
                new PeriodFavoriteOverSingleBlock(1.5),
                new PeriodFavoriteOverSingleBlock(2.5),
                new PeriodFavoriteOverSingleBlock(3.5),
                new PeriodFavoriteOverSingleBlock(4.5)
        ), function);
    }


}
