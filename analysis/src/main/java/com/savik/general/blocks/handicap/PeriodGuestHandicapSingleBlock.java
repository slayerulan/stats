package com.savik.general.blocks.handicap;

import com.savik.bets.general.handicap.PeriodGuestHandicap;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestHandicapSingleBlock extends PeriodBetContainer {

    public PeriodGuestHandicapSingleBlock(double amount) {
        super(new PeriodGuestHandicap(amount));
    }


}
