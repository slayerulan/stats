package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.PeriodFavoriteHandicap;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteHandicapSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodFavoriteHandicapSingleBlock(double amount) {
        super(new PeriodFavoriteHandicap(amount));
    }


}
