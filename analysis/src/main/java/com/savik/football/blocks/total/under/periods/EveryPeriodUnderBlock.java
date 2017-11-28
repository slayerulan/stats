package com.savik.football.blocks.total.under.periods;

import com.savik.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodUnderBlock extends GeneralBetContainer {

    public EveryPeriodUnderBlock() {
        super(Arrays.asList(
                new EveryPeriodUnderSingleBlock(0.5),
                new EveryPeriodUnderSingleBlock(1.5),
                new EveryPeriodUnderSingleBlock(2.5)
        ));
    }


}
