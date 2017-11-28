package com.savik.football.blocks.total.under;

import com.savik.football.bets.total.under.PeriodGuestUnder;
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
