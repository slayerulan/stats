package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.match.MatchFavoriteOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteOverSingleBlock extends GeneralBetContainer {

    public FavoriteOverSingleBlock(int amount) {
        super(new MatchFavoriteOver(amount));
    }


}
