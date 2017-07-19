package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.PeriodGuestHandicap;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestHandicapSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodGuestHandicapSingleBlock(double amount) {
        super(new PeriodGuestHandicap(amount));
    }


}
