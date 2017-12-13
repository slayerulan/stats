package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodPowerplayGoalsOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodPowerplayGoalsOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodPowerplayGoalsOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodPowerplayGoalsOver(amount), type);
    }

    public PeriodPowerplayGoalsOverSingleBlock(double amount, Function<HockeyMatch, Period> function) {
        super(new PeriodPowerplayGoalsOver(amount), function);
    }

}
