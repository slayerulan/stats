package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.goals.TotalOverInAllPeriods;
import com.savik.hockey.model.HockeyMatch;


public class TotalOverInAllPeriodsSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public TotalOverInAllPeriodsSingleBlock(double amount, ContainerType type) {
        super(new TotalOverInAllPeriods(amount), type);
    }

    public TotalOverInAllPeriodsSingleBlock(double amount) {
        super(new TotalOverInAllPeriods(amount));
    }
}
