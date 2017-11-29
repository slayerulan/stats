package com.savik.general.blocks.total.under;

import com.savik.general.bets.total.under.PeriodHomeUnder;
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
