package com.savik.general.blocks.handicap;

import com.savik.bets.general.handicap.PeriodFavoriteHandicap;
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
