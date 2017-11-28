package com.savik.football.blocks.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteUnderBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteUnderBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodFavoriteUnderSingleBlock(0.5),
                new PeriodFavoriteUnderSingleBlock(1.5),
                new PeriodFavoriteUnderSingleBlock(2.5),
                new PeriodFavoriteUnderSingleBlock(3.5),
                new PeriodFavoriteUnderSingleBlock(4.5)
        ), function);
    }


}
