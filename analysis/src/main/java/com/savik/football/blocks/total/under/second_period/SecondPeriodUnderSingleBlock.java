package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.second_period.SecondPeriodUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodUnderSingleBlock extends GeneralBetContainer {

    public SecondPeriodUnderSingleBlock(double amount) {
        super(new SecondPeriodUnder(amount));
    }


}
