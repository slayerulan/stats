package com.savik.football.blocks.total.under;

import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodUnderSingleBlock extends PeriodBetContainer {

    public PeriodUnderSingleBlock(double amount) {
        super(new PeriodUnder(amount));
    }


}
