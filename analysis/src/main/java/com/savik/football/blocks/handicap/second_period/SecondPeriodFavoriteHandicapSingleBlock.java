package com.savik.football.blocks.handicap.second_period;

import com.savik.football.bets.handicap.first_period.FirstPeriodFavoriteHandicap;
import com.savik.football.bets.handicap.second_period.SecondPeriodFavoriteHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteHandicapSingleBlock extends GeneralBetContainer {

    public SecondPeriodFavoriteHandicapSingleBlock(double amount) {
        super(new SecondPeriodFavoriteHandicap(amount));
    }


}
