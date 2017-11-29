package com.savik.blocks.general.handicap;

import com.savik.bets.general.handicap.PeriodHomeHandicap;
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
