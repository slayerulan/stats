package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodLoserOver;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserOverSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserOverSingleBlock(double amount) {
        super(new PeriodLoserOver(amount));
    }


}
