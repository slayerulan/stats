package com.savik.bets.hockey.stats;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodPowerplayGoalsOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PowerplayGoalsTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PowerplayGoalsTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodPowerplayGoalsOverSingleBlock(amount, function),
                new PeriodPowerplayGoalsOverSingleBlock(amount, function)
        );
    }
}
