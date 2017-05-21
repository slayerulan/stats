package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.second_period.SecondPeriodGuestHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestHandicapSingleBlock extends GeneralBetContainer {

    public SecondPeriodGuestHandicapSingleBlock(int amount) {
        super(new SecondPeriodGuestHandicap(amount));
    }


}
