package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.second_period.SecondPeriodFavoriteUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteUnderSingleBlock extends GeneralBetContainer {

    public SecondPeriodFavoriteUnderSingleBlock(int amount) {
        super(new SecondPeriodFavoriteUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
