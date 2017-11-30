package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodShotsOnTargetOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodShotsOnTargetOverSingleBlock(double amount) {
        super(new PeriodShotsOnTargetOver(amount));
    }

}
