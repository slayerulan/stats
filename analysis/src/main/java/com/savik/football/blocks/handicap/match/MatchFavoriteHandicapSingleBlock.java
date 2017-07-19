package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.PeriodFavoriteHandicap;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteHandicapSingleBlock extends MatchPeriodFavoriteBetContainer {

    public MatchFavoriteHandicapSingleBlock(double amount) {
        super(new PeriodFavoriteHandicap(amount));
    }


}
