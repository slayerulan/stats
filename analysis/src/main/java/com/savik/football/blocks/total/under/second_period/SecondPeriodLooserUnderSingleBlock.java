package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodLoserUnder;
import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLooserUnderSingleBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLooserUnderSingleBlock(double amount) {
        super(new PeriodLoserUnder(amount));
    }


}
