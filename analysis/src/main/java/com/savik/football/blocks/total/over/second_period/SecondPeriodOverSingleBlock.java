package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.second_period.SecondPeriodOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodOverSingleBlock extends GeneralBetContainer {

    public SecondPeriodOverSingleBlock(double amount) {
        super(new SecondPeriodOver(amount));
    }


}