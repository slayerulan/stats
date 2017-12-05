package com.savik.blocks.general.total.under;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.under.PeriodUnder;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodUnderSingleBlock extends PeriodBetContainer {

    public PeriodUnderSingleBlock(double amount, ContainerType type) {
        super(new PeriodUnder(amount), type);
    }


}
