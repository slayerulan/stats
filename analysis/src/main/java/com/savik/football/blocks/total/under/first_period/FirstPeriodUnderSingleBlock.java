package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodUnderSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodUnderSingleBlock(double amount) {
        super(new PeriodUnder(amount));
    }


}
