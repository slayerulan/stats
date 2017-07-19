package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.PeriodLoserHandicap;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserHandicapSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserHandicapSingleBlock(double amount) {
        super(new PeriodLoserHandicap(amount));
    }


}
