package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.match.MatchFavoriteHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteHandicapSingleBlock extends GeneralBetContainer {

    public MatchFavoriteHandicapSingleBlock(int amount) {
        super(new MatchFavoriteHandicap(amount));
    }


}
