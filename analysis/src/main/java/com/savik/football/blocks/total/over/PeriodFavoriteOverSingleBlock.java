package com.savik.football.blocks.total.over;

import com.savik.football.bets.total.over.PeriodFavoriteOver;
import com.savik.football.blocks.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteOverSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteOverSingleBlock(double amount) {
        super(new PeriodFavoriteOver(amount));
    }


}
