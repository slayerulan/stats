package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeOverSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodHomeOverSingleBlock(double amount) {
        super(new PeriodHomeOver(amount));
    }

}
