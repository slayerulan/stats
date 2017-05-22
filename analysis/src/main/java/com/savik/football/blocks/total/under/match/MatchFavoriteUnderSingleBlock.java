package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.match.MatchFavoriteUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteUnderSingleBlock extends GeneralBetContainer {

    public MatchFavoriteUnderSingleBlock(double amount) {
        super(new MatchFavoriteUnder(amount));
    }


}