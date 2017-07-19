package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.PeriodFavoriteUnder;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteUnderSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodFavoriteUnderSingleBlock(double amount) {
        super(new PeriodFavoriteUnder(amount));
    }


}
