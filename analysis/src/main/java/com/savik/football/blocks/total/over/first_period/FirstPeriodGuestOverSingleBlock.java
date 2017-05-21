package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodGuestOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestOverSingleBlock extends GeneralBetContainer {

    public FirstPeriodGuestOverSingleBlock(int amount) {
        super(new FirstPeriodGuestOver(amount));
    }


}
