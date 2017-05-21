package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.match.MatchGuestOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestOverSingleBlock extends GeneralBetContainer {

    public GuestOverSingleBlock(int amount) {
        super(new MatchGuestOver(amount));
    }


}
