package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodTeamShotsOnTargetOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamShotsOnTargetOverSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodHomeShotsOnTargetOver(amount),
                new PeriodGuestShotsOnTargetOver(amount),
                type
        );
    }

}
