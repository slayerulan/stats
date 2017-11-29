package com.savik.general.blocks.total.over;

import com.savik.bets.general.total.over.PeriodFavoriteOver;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteOverSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteOverSingleBlock(double amount) {
        super(new PeriodFavoriteOver(amount));
    }


}
