package com.savik.blocks.general.total.over.periods;

import com.savik.bets.football.totals.periods.EveryPeriodOver;
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
