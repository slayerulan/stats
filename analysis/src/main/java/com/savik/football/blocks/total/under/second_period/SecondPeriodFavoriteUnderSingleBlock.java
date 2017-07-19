package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodFavoriteUnder;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteUnderSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteUnderSingleBlock(double amount) {
        super(new PeriodFavoriteUnder(amount));
    }


}
