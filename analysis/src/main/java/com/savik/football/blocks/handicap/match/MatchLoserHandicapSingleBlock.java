package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.PeriodLoserHandicap;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLoserHandicapSingleBlock extends MatchPeriodFavoriteBetContainer {

    public MatchLoserHandicapSingleBlock(double amount) {
        super(new PeriodLoserHandicap(amount));
    }


}
