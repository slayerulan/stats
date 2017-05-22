package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.first_period.FirstPeriodFavoriteUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteUnderSingleBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteUnderSingleBlock(double amount) {
        super(new FirstPeriodFavoriteUnder(amount));
    }


}
