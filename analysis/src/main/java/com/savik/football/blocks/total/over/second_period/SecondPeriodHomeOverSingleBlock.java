package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeOverSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodHomeOverSingleBlock(double amount) {
        super(new PeriodHomeOver(amount));
    }

}
