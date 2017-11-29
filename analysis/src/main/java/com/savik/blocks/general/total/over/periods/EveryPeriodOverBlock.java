package com.savik.blocks.general.total.over.periods;

import com.savik.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodOverBlock extends GeneralBetContainer {

    public EveryPeriodOverBlock() {
        super(Arrays.asList(
                new EveryPeriodOverSingleBlock(0.5),
                new EveryPeriodOverSingleBlock(1.5)
        ));
    }


}
