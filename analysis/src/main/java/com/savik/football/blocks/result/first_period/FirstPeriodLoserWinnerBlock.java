package com.savik.football.blocks.result.first_period;

import com.savik.football.bets.result.PeriodLoserWinner;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserWinnerBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserWinnerBlock() {
        super(new PeriodLoserWinner());
    }


}
