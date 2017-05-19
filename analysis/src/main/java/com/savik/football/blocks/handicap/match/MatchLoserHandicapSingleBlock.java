package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.match.MatchLoserHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLoserHandicapSingleBlock extends GeneralBetContainer {

    public MatchLoserHandicapSingleBlock(int amount) {
        super(new MatchLoserHandicap(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
