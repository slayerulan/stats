package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestMinorPenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodGuestPenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodGuestPenaltiesTimeOverSingleBlock(double amount) {
        super(new PeriodGuestMinorPenaltiesTimeOver(amount));
    }

}
