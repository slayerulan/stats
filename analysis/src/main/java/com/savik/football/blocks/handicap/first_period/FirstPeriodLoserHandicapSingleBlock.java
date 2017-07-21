package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.PeriodLoserHandicap;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserHandicapSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserHandicapSingleBlock(double amount) {
        super(new PeriodLoserHandicap(amount));
    }


}
