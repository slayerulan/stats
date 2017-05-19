package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.first_period.FirstPeriodGuestHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestHandicapSingleBlock extends GeneralBetContainer {

    public FirstPeriodGuestHandicapSingleBlock(int amount) {
        super(new FirstPeriodGuestHandicap(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
