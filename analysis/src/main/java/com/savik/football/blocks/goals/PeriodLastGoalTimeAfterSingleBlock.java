package com.savik.football.blocks.goals;

import com.savik.PeriodBetContainer;
import com.savik.football.bets.goals.match.LastGoalTimeAfter;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLastGoalTimeAfterSingleBlock extends PeriodBetContainer {

    public PeriodLastGoalTimeAfterSingleBlock(double amount) {
        super(new LastGoalTimeAfter(amount));
    }


}
