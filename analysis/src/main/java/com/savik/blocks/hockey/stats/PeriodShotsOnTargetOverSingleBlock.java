package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodShotsOnTargetOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodShotsOnTargetOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodShotsOnTargetOver(amount), type);
    }

    public PeriodShotsOnTargetOverSingleBlock(double amount, Function<HockeyMatch, Period> function) {
        super(new PeriodShotsOnTargetOver(amount), function);
    }
}
