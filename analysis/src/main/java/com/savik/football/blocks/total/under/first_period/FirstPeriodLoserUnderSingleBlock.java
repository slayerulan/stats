package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.PeriodLoserUnder;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserUnderSingleBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserUnderSingleBlock(double amount) {
        super(new PeriodLoserUnder(amount));
    }


}
