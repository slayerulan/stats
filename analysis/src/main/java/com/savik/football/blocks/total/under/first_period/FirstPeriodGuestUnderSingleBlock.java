package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.PeriodGuestUnder;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestUnderSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodGuestUnderSingleBlock(double amount) {
        super(new PeriodGuestUnder(amount));
    }


}
