package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodFavoriteOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteOverSingleBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteOverSingleBlock(double amount) {
        super(new FirstPeriodFavoriteOver(amount));
    }


}
