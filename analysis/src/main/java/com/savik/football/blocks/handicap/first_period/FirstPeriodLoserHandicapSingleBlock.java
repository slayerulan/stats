package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.first_period.FirstPeriodHomeHandicap;
import com.savik.football.bets.handicap.first_period.FirstPeriodLoserHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserHandicapSingleBlock extends GeneralBetContainer {

    public FirstPeriodLoserHandicapSingleBlock(int amount) {
        super(new FirstPeriodLoserHandicap(amount));
    }


}
