package com.savik.football.blocks.handicap;

import com.savik.football.bets.handicap.PeriodFavoriteHandicap;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteHandicapSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteHandicapSingleBlock(double amount) {
        super(new PeriodFavoriteHandicap(amount));
    }


}
