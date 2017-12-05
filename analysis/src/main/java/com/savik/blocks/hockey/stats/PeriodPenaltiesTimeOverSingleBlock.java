package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.hockey.stats.PeriodPenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

public class PeriodPenaltiesTimeOverSingleBlock extends PeriodBetContainer<HockeyMatch> {

    public PeriodPenaltiesTimeOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodPenaltiesTimeOver(amount), type);
    }

}
