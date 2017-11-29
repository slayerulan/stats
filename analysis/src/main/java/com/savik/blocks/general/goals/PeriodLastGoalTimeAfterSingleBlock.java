package com.savik.blocks.general.goals;

import com.savik.PeriodBetContainer;
import com.savik.bets.football.goals.match.LastGoalTimeAfter;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLastGoalTimeAfterSingleBlock extends PeriodBetContainer {

    public PeriodLastGoalTimeAfterSingleBlock(double amount) {
        super(new LastGoalTimeAfter(amount));
    }


}
