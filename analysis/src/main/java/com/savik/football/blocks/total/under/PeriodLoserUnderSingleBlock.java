package com.savik.football.blocks.total.under;

import com.savik.football.bets.total.under.PeriodLoserUnder;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserUnderSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserUnderSingleBlock(double amount) {
        super(new PeriodLoserUnder(amount));
    }


}
