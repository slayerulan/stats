package com.savik.football.blocks.handicap;

import com.savik.football.bets.handicap.PeriodGuestHandicap;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestHandicapSingleBlock extends PeriodBetContainer {

    public PeriodGuestHandicapSingleBlock(double amount) {
        super(new PeriodGuestHandicap(amount));
    }


}
