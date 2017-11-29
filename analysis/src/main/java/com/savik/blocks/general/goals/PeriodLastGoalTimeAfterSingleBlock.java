package com.savik.blocks.general.goals;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodLastGoalTimeAfter;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLastGoalTimeAfterSingleBlock extends PeriodBetContainer {

    public PeriodLastGoalTimeAfterSingleBlock(double amount) {
        super(new PeriodLastGoalTimeAfter(amount));
    }


}
