package com.savik.blocks.general.total.under;

import com.savik.bets.general.total.under.PeriodFavoriteUnder;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteUnderSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteUnderSingleBlock(double amount) {
        super(new PeriodFavoriteUnder(amount));
    }


}
