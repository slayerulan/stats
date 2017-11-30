package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodHomePenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodHomePenaltiesTimeOverSingleBlock(double amount) {
        super(new PeriodHomePenaltiesTimeOver(amount));
    }

}
