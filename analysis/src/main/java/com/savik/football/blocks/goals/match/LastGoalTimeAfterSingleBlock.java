package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.FirstGoalTimeBefore;
import com.savik.football.bets.goals.match.LastGoalTimeAfter;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LastGoalTimeAfterSingleBlock extends GeneralBetContainer {

    public LastGoalTimeAfterSingleBlock(int amount) {
        super(new LastGoalTimeAfter(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
