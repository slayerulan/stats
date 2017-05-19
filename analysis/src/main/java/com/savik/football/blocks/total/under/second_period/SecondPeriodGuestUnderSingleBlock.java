package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.second_period.SecondPeriodGuestUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestUnderSingleBlock extends GeneralBetContainer {

    public SecondPeriodGuestUnderSingleBlock(int amount) {
        super(new SecondPeriodGuestUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
