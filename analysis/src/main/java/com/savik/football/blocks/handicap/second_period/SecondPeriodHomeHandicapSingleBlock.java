package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.PeriodHomeHandicap;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeHandicapSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodHomeHandicapSingleBlock(double amount) {
        super(new PeriodHomeHandicap(amount));
    }


}
