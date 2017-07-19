package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestOverSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodGuestOverSingleBlock(double amount) {
        super(new PeriodGuestOver(amount));
    }


}
