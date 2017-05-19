package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.first_period.FirstPeriodGuestUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestUnderSingleBlock extends GeneralBetContainer {

    public FirstPeriodGuestUnderSingleBlock(int amount) {
        super(new FirstPeriodGuestUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
