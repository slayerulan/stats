package com.savik.football.blocks.total.periods;

import com.savik.football.bets.total.periods.FirstPeriodMostGoals;
import com.savik.football.bets.total.periods.SecondPeriodMostGoals;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodMostGoalsBlock extends GeneralBetContainer {

    public SecondPeriodMostGoalsBlock() {
        super(new SecondPeriodMostGoals());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
