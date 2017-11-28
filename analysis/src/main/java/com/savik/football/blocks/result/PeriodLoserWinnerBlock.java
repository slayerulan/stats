package com.savik.football.blocks.result;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;
import com.savik.football.bets.result.PeriodLoserWinner;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserWinnerBlock<T extends Match> extends PeriodFavoriteBetContainer {

    public PeriodLoserWinnerBlock(Function<T, Period> function) {
        super(new PeriodLoserWinner(), function);
    }


}
