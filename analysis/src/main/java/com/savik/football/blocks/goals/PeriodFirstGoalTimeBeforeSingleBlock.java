package com.savik.football.blocks.goals;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.football.bets.goals.match.PeriodFirstGoalTimeBefore;
import com.savik.GeneralBetContainer;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFirstGoalTimeBeforeSingleBlock extends PeriodBetContainer {

    public PeriodFirstGoalTimeBeforeSingleBlock(double amount) {
        super(new PeriodFirstGoalTimeBefore(amount));
    }


}
