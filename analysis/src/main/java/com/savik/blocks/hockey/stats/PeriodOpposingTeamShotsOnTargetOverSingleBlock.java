package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodOpposingTeamShotsOnTargetOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamShotsOnTargetOverSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodGuestShotsOnTargetOver(amount),
                new PeriodHomeShotsOnTargetOver(amount),
                type
        );
    }

}
