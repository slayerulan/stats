package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodPenaltiesTimeOver;
import com.savik.bets.hockey.stats.PeriodShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodPenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodPenaltiesTimeOverSingleBlock(double amount) {
        super(new PeriodPenaltiesTimeOver(amount));
    }

}
