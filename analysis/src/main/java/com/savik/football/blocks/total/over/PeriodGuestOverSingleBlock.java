package com.savik.football.blocks.total.over;

import com.savik.football.bets.total.over.PeriodGuestOver;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestOverSingleBlock extends PeriodBetContainer {

    public PeriodGuestOverSingleBlock(double amount) {
        super(new PeriodGuestOver(amount));
    }


}
