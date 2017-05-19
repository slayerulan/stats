package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.handicap.first_period.FirstPeriodFavoriteHandicap;
import com.savik.football.bets.handicap.first_period.FirstPeriodHomeHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeHandicapSingleBlock extends GeneralBetContainer {

    public FirstPeriodHomeHandicapSingleBlock(int amount) {
        super(new FirstPeriodHomeHandicap(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
