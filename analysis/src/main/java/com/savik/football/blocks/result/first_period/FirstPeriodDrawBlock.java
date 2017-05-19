package com.savik.football.blocks.result.first_period;

import com.savik.football.bets.result.first_period.FirstPeriodDraw;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodDrawBlock extends GeneralBetContainer {

    public FirstPeriodDrawBlock() {
        super(new FirstPeriodDraw());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
