package com.savik.football.blocks.handicap;

import com.savik.football.bets.handicap.PeriodHomeHandicap;
import com.savik.football.blocks.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeHandicapSingleBlock extends PeriodBetContainer {

    public PeriodHomeHandicapSingleBlock(double amount) {
        super(new PeriodHomeHandicap(amount));
    }

}
