package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.goals.match.TotalUnderInAllPeriods;
import com.savik.hockey.model.HockeyMatch;


public class TotalUnderInAllPeriodsSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public TotalUnderInAllPeriodsSingleBlock(double amount, ContainerType type) {
        super(new TotalUnderInAllPeriods(amount), type);
    }
}
