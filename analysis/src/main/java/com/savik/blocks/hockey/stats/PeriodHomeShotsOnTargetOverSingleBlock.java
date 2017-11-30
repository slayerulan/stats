package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodHomeShotsOnTargetOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodHomeShotsOnTargetOverSingleBlock(double amount) {
        super(new PeriodHomeShotsOnTargetOver(amount));
    }

}
