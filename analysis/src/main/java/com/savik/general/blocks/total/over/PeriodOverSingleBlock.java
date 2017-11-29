package com.savik.general.blocks.total.over;

import com.savik.bets.general.total.over.PeriodOver;
import com.savik.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOverSingleBlock extends PeriodBetContainer {

    public PeriodOverSingleBlock(double amount) {
        super(new PeriodOver(amount));
    }


}
