package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.PeriodHomeHandicap;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeHandicapSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodHomeHandicapSingleBlock(double amount) {
        super(new PeriodHomeHandicap(amount));
    }

}
