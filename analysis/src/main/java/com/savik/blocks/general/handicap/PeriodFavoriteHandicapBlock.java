package com.savik.blocks.general.handicap;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteHandicapBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteHandicapBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodFavoriteHandicapSingleBlock(1.5),
                new PeriodFavoriteHandicapSingleBlock(2.5),
                new PeriodFavoriteHandicapSingleBlock(3.5)
        ), function);
    }


}
