package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.LastGoalTimeAfter;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LastGoalTimeAfterSingleBlock extends GeneralBetContainer {

    public LastGoalTimeAfterSingleBlock(double amount) {
        super(new LastGoalTimeAfter(amount));
    }


}
