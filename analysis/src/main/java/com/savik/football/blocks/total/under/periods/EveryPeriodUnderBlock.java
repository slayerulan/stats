package com.savik.football.blocks.total.under.periods;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodUnderBlock extends GeneralBetContainer {

    public EveryPeriodUnderBlock() {
        super(Arrays.asList(
                new EveryPeriodUnderSingleBlock(0),
                new EveryPeriodUnderSingleBlock(1),
                new EveryPeriodUnderSingleBlock(2)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
