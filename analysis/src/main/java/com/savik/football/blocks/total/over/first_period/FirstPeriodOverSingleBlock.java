package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodOverSingleBlock extends GeneralBetContainer {

    public FirstPeriodOverSingleBlock(int amount) {
        super(new FirstPeriodOver(amount));
    }


}
