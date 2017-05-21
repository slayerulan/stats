package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.second_period.SecondPeriodFavoriteOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteOverSingleBlock extends GeneralBetContainer {

    public SecondPeriodFavoriteOverSingleBlock(int amount) {
        super(new SecondPeriodFavoriteOver(amount));
    }


}
