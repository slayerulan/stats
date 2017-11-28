package com.savik.football.blocks.result;

import com.savik.football.bets.result.PeriodFavoriteWinner;
import com.savik.football.blocks.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteWinnerBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteWinnerBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodFavoriteWinner(), function);
    }


}
