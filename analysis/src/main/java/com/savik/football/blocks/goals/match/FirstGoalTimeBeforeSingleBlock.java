package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.AtLeastOneTeamNotScoredAndUnder;
import com.savik.football.bets.goals.match.FirstGoalTimeBefore;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstGoalTimeBeforeSingleBlock extends GeneralBetContainer {

    public FirstGoalTimeBeforeSingleBlock(int amount) {
        super(new FirstGoalTimeBefore(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
