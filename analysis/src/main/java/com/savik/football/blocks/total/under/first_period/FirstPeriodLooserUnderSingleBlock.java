package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodLoserOver;
import com.savik.football.bets.total.under.first_period.FirstPeriodLoserUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserUnderSingleBlock extends GeneralBetContainer {

    public FirstPeriodLooserUnderSingleBlock(int amount) {
        super(new FirstPeriodLoserUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
