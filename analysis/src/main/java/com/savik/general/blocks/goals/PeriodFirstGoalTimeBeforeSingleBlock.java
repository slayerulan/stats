package com.savik.general.blocks.goals;

import com.savik.PeriodBetContainer;
import com.savik.football.bets.goals.match.PeriodFirstGoalTimeBefore;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFirstGoalTimeBeforeSingleBlock extends PeriodBetContainer {

    public PeriodFirstGoalTimeBeforeSingleBlock(double amount) {
        super(new PeriodFirstGoalTimeBefore(amount));
    }


}
