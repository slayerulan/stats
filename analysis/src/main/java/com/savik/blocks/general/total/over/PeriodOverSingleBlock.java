package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodOver;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOverSingleBlock extends PeriodBetContainer {

    public PeriodOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodOver(amount), type);
    }


}
