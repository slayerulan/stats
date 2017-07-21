package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.PeriodLoserOver;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserOverSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserOverSingleBlock(double amount) {
        super(new PeriodLoserOver(amount));
    }


}
