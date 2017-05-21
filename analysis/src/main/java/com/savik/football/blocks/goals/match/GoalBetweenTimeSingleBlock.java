package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.GoalBetweenTime;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalBetweenTimeSingleBlock extends GeneralBetContainer {

    public GoalBetweenTimeSingleBlock(int from, int before) {
        super(new GoalBetweenTime(from, before));
    }


}
