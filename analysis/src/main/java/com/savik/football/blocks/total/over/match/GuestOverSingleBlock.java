package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestOverSingleBlock extends MatchPeriodBetContainer {

    public GuestOverSingleBlock(double amount) {
        super(new PeriodGuestOver(amount));
    }


}
