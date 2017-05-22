package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.match.MatchHomeHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeHandicapSingleBlock extends GeneralBetContainer {

    public MatchHomeHandicapSingleBlock(double amount) {
        super(new MatchHomeHandicap(amount));
    }


}
