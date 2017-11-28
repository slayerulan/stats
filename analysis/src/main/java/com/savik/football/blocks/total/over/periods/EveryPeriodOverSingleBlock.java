package com.savik.football.blocks.total.over.periods;

import com.savik.football.bets.total.over.periods.EveryPeriodOver;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodOverSingleBlock extends GeneralBetContainer {

    public EveryPeriodOverSingleBlock(double amount) {
        super(new EveryPeriodOver(amount));
    }


}
