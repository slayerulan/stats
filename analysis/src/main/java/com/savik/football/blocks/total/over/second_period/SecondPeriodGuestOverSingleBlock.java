package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.second_period.SecondPeriodGuestOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestOverSingleBlock extends GeneralBetContainer {

    public SecondPeriodGuestOverSingleBlock(int amount) {
        super(new SecondPeriodGuestOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
