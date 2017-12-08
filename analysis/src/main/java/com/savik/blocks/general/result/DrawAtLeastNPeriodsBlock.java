package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.Match;
import com.savik.bets.hockey.result.DrawAtLeastNPeriods;


public class DrawAtLeastNPeriodsBlock<T extends Match> extends GeneralBetContainer<T> {

    public DrawAtLeastNPeriodsBlock(int n, ContainerType type) {
        super(
                new DrawAtLeastNPeriods(n),
                type
        );
    }

    public DrawAtLeastNPeriodsBlock(int n) {
        super(new DrawAtLeastNPeriods(n));
    }

}
