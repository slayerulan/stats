package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeOverBlock extends GeneralBetContainer {

    public FirstPeriodHomeOverBlock() {
        super(Arrays.asList(
                new FirstPeriodHomeOverSingleBlock(0),
                new FirstPeriodHomeOverSingleBlock(1),
                new FirstPeriodHomeOverSingleBlock(2),
                new FirstPeriodHomeOverSingleBlock(3),
                new FirstPeriodHomeOverSingleBlock(4)
        ));
    }


}
