package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.PeriodFavoriteOver;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteOverSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteOverSingleBlock(double amount) {
        super(new PeriodFavoriteOver(amount));
    }


}
