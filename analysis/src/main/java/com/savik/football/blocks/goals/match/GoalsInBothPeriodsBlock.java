package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.GoalsInBothPeriods;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalsInBothPeriodsBlock extends GeneralBetContainer {

    public GoalsInBothPeriodsBlock() {
        super(new GoalsInBothPeriods());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
