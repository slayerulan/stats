package com.savik.general.blocks.total.under;

import com.savik.bets.general.total.under.PeriodUnder;
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
