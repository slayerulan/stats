package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.first_period.FirstPeriodUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodUnderSingleBlock extends GeneralBetContainer {

    public FirstPeriodUnderSingleBlock(double amount) {
        super(new FirstPeriodUnder(amount));
    }


}