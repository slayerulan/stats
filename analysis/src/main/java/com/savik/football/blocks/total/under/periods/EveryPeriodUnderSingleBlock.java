package com.savik.football.blocks.total.under.periods;

import com.savik.football.bets.total.under.periods.EveryPeriodUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodUnderSingleBlock extends GeneralBetContainer {

    public EveryPeriodUnderSingleBlock(int amount) {
        super(new EveryPeriodUnder(amount));
    }


}
