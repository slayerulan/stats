package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodPenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodPenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodPenaltiesTimeOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodPenaltiesTimeOver(amount), type);
    }

    public PeriodPenaltiesTimeOverSingleBlock(double amount, Function<HockeyMatch, Period> function) {
        super(new PeriodPenaltiesTimeOver(amount), function);
    }

}
