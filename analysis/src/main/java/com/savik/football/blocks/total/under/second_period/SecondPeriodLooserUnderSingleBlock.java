package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.second_period.SecondPeriodLoserUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLooserUnderSingleBlock extends GeneralBetContainer {

    public SecondPeriodLooserUnderSingleBlock(int amount) {
        super(new SecondPeriodLoserUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
