package com.savik.general.blocks.handicap;

import com.savik.general.bets.handicap.PeriodLoserHandicap;
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
