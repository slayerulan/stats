package com.savik.football.blocks.handicap;

import com.savik.football.bets.handicap.PeriodLoserHandicap;
import com.savik.football.blocks.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserHandicapSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserHandicapSingleBlock(double amount) {
        super(new PeriodLoserHandicap(amount));
    }


}
