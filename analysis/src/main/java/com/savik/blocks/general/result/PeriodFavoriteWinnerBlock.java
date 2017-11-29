package com.savik.blocks.general.result;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;
import com.savik.bets.general.result.PeriodFavoriteWinner;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteWinnerBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteWinnerBlock(Function<T, Period> function) {
        super(new PeriodFavoriteWinner(), function);
    }


}
