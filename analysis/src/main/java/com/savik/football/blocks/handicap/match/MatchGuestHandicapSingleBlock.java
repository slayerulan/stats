package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.PeriodGuestHandicap;
import com.savik.football.blocks.MatchPeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchGuestHandicapSingleBlock extends MatchPeriodBetContainer {

    public MatchGuestHandicapSingleBlock(double amount) {
        super(new PeriodGuestHandicap(amount));
    }


}
