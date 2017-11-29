package com.savik.blocks.general.handicap;

import com.savik.bets.general.handicap.PeriodLoserHandicap;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserHandicapSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserHandicapSingleBlock(double amount) {
        super(new PeriodLoserHandicap(amount));
    }


}
