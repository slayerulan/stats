package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.FirstGoalTimeBefore;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstGoalTimeBeforeSingleBlock extends GeneralBetContainer {

    public FirstGoalTimeBeforeSingleBlock(double amount) {
        super(new FirstGoalTimeBefore(amount));
    }


}
