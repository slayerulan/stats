package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodOverSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodOverSingleBlock(double amount) {
        super(new PeriodOver(amount));
    }


}
