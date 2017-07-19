package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodGuestUnder;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestUnderSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodGuestUnderSingleBlock(double amount) {
        super(new PeriodGuestUnder(amount));
    }


}
