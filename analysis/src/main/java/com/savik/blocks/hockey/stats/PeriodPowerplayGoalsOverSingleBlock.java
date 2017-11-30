package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodPowerplayGoalsOver;
import com.savik.bets.hockey.stats.PeriodShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodPowerplayGoalsOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodPowerplayGoalsOverSingleBlock(double amount) {
        super(new PeriodPowerplayGoalsOver(amount));
    }

}
