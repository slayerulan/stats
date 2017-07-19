package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.PeriodGuestHandicap;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestHandicapSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodGuestHandicapSingleBlock(double amount) {
        super(new PeriodGuestHandicap(amount));
    }
}
