package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.PeriodGuestUnder;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestUnderSingleBlock extends MatchPeriodBetContainer {

    public MatchGuestUnderSingleBlock(double amount) {
        super(new PeriodGuestUnder(amount));
    }


}
