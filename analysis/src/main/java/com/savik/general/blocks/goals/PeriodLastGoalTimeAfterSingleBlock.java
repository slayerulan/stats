package com.savik.general.blocks.goals;

import com.savik.PeriodBetContainer;
import com.savik.football.bets.goals.match.LastGoalTimeAfter;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLastGoalTimeAfterSingleBlock extends PeriodBetContainer {

    public PeriodLastGoalTimeAfterSingleBlock(double amount) {
        super(new LastGoalTimeAfter(amount));
    }


}
