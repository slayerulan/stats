package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodUnderSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodUnderSingleBlock(double amount) {
        super(new PeriodUnder(amount));
    }


}
