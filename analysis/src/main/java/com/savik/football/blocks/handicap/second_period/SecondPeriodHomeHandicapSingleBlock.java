package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.second_period.SecondPeriodHomeHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeHandicapSingleBlock extends GeneralBetContainer {

    public SecondPeriodHomeHandicapSingleBlock(int amount) {
        super(new SecondPeriodHomeHandicap(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
