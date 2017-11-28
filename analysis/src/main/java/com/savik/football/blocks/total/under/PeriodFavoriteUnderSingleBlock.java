package com.savik.football.blocks.total.under;

import com.savik.football.bets.total.under.PeriodFavoriteUnder;
import com.savik.football.blocks.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteUnderSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteUnderSingleBlock(double amount) {
        super(new PeriodFavoriteUnder(amount));
    }


}
