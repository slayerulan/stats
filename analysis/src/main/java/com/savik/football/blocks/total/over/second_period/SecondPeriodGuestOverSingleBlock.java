package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestOverSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodGuestOverSingleBlock(double amount) {
        super(new PeriodGuestOver(amount));
    }


}
