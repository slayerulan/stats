package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodOverSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodOverSingleBlock(double amount) {
        super(new PeriodOver(amount));
    }


}
