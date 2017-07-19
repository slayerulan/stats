package com.savik.football.blocks.handicap.match;

import com.savik.football.bets.handicap.PeriodHomeHandicap;
import com.savik.football.blocks.MatchPeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeHandicapSingleBlock extends MatchPeriodBetContainer {

    public MatchHomeHandicapSingleBlock(double amount) {
        super(new PeriodHomeHandicap(amount));
    }


}
