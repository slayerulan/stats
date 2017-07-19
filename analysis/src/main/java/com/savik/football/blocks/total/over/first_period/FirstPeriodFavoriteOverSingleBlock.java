package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodFavoriteOver;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteOverSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodFavoriteOverSingleBlock(double amount) {
        super(new PeriodFavoriteOver(amount));
    }


}
