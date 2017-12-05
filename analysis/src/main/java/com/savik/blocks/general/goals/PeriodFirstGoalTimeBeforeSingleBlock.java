package com.savik.blocks.general.goals;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodFirstGoalTimeBefore;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFirstGoalTimeBeforeSingleBlock extends PeriodBetContainer {

    public PeriodFirstGoalTimeBeforeSingleBlock(double amount, ContainerType type) {
        super(new PeriodFirstGoalTimeBefore(amount), type);
    }


}
