package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodLoserOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserOverSingleBlock extends GeneralBetContainer {

    public FirstPeriodLooserOverSingleBlock(double amount) {
        super(new FirstPeriodLoserOver(amount));
    }


}
