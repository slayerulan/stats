package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodLoserUnder;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserUnderSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserUnderSingleBlock(double amount) {
        super(new PeriodLoserUnder(amount));
    }


}
