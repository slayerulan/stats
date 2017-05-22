package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.match.MatchGuestHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestHandicapSingleBlock extends GeneralBetContainer {

    public MatchGuestHandicapSingleBlock(double amount) {
        super(new MatchGuestHandicap(amount));
    }


}
