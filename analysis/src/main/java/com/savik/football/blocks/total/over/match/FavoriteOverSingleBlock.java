package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodFavoriteOver;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteOverSingleBlock extends MatchPeriodFavoriteBetContainer {

    public FavoriteOverSingleBlock(double amount) {
        super(new PeriodFavoriteOver(amount));
    }


}
