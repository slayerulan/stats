package com.savik.football.blocks.result;

import com.savik.football.bets.result.PeriodLoserWinner;
import com.savik.football.blocks.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserWinnerBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserWinnerBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodLoserWinner(), function);
    }


}
