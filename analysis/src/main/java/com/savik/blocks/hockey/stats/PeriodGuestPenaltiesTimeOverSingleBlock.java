package com.savik.blocks.hockey.stats;

import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestPenaltiesTimeOver;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodGuestPenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodGuestPenaltiesTimeOverSingleBlock(double amount) {
        super(new PeriodGuestPenaltiesTimeOver(amount));
    }

}
