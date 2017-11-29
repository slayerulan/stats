package com.savik.blocks.hockey.goals.match;

import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.goals.match.TotalUnderInAllPeriods;
import com.savik.hockey.model.HockeyMatch;


public class TotalUnderInAllPeriodsSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public TotalUnderInAllPeriodsSingleBlock(double amount) {
        super(new TotalUnderInAllPeriods(amount));
    }
}
