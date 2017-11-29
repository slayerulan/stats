package com.savik.blocks.general.total.under;

import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeUnderSingleBlock extends PeriodBetContainer {

    public PeriodHomeUnderSingleBlock(double amount) {
        super(new PeriodHomeUnder(amount));
    }


}
