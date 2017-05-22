package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.second_period.SecondPeriodLoserHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserHandicapSingleBlock extends GeneralBetContainer {

    public SecondPeriodLoserHandicapSingleBlock(double amount) {
        super(new SecondPeriodLoserHandicap(amount));
    }


}
