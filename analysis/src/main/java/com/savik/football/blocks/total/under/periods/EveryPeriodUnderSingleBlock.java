package com.savik.football.blocks.total.under.periods;

import com.savik.football.bets.total.under.periods.EveryPeriodUnder;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodUnderSingleBlock extends GeneralBetContainer {

    public EveryPeriodUnderSingleBlock(double amount) {
        super(new EveryPeriodUnder(amount));
    }


}
