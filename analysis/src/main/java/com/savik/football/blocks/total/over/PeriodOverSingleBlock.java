package com.savik.football.blocks.total.over;

import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOverSingleBlock extends PeriodBetContainer {

    public PeriodOverSingleBlock(double amount) {
        super(new PeriodOver(amount));
    }


}
