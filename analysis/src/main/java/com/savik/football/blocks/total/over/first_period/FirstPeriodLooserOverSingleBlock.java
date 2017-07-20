package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodLooserOver;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserOverSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLooserOverSingleBlock(double amount) {
        super(new PeriodLooserOver(amount));
    }


}
