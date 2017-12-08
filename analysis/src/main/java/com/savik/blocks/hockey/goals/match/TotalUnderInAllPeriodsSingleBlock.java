package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.goals.TotalUnderInAllPeriods;
import com.savik.hockey.model.HockeyMatch;


public class TotalUnderInAllPeriodsSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public TotalUnderInAllPeriodsSingleBlock(double amount, ContainerType type) {
        super(new TotalUnderInAllPeriods(amount), type);
    }

    public TotalUnderInAllPeriodsSingleBlock(double amount) {
        super(new TotalUnderInAllPeriods(amount));
    }
}
