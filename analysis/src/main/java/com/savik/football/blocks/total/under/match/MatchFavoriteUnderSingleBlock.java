package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.over.match.MatchFavoriteOver;
import com.savik.football.bets.total.under.match.MatchFavoriteUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteUnderSingleBlock extends GeneralBetContainer {

    public MatchFavoriteUnderSingleBlock(int amount) {
        super(new MatchFavoriteUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
