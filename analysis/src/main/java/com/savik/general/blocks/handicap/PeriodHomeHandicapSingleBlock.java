package com.savik.general.blocks.handicap;

import com.savik.general.bets.handicap.PeriodHomeHandicap;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeHandicapSingleBlock extends PeriodBetContainer {

    public PeriodHomeHandicapSingleBlock(double amount) {
        super(new PeriodHomeHandicap(amount));
    }

}
