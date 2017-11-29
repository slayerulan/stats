package com.savik.blocks.general.total.under;

import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestUnderSingleBlock extends PeriodBetContainer {

    public PeriodGuestUnderSingleBlock(double amount) {
        super(new PeriodGuestUnder(amount));
    }


}