package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.PeriodFavoriteHandicap;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteHandicapSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteHandicapSingleBlock(double amount) {
        super(new PeriodFavoriteHandicap(amount));
    }


}
