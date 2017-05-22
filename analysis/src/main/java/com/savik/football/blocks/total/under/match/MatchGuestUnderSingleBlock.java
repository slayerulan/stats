package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.match.MatchGuestUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestUnderSingleBlock extends GeneralBetContainer {

    public MatchGuestUnderSingleBlock(double amount) {
        super(new MatchGuestUnder(amount));
    }


}
