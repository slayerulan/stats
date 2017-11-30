package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodGuestShotsOnTargetOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodGuestShotsOnTargetOverSingleBlock(double amount) {
        super(new PeriodGuestShotsOnTargetOver(amount));
    }

}
