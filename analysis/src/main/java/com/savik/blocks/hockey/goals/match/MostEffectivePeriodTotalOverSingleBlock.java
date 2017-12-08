package com.savik.blocks.hockey.goals.match;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.goals.match.MostEffectivePeriodTotalOver;
import com.savik.hockey.model.HockeyMatch;


public class MostEffectivePeriodTotalOverSingleBlock extends GeneralBetContainer<HockeyMatch> {

    public MostEffectivePeriodTotalOverSingleBlock(double amount, ContainerType type) {
        super(new MostEffectivePeriodTotalOver(amount), type);
    }

    public MostEffectivePeriodTotalOverSingleBlock(double amount) {
        super(new MostEffectivePeriodTotalOver(amount));
    }
}
