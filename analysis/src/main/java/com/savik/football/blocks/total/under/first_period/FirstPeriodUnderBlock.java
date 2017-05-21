package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodUnderBlock extends GeneralBetContainer {

    public FirstPeriodUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodUnderSingleBlock(0),
                new FirstPeriodUnderSingleBlock(1),
                new FirstPeriodUnderSingleBlock(2),
                new FirstPeriodUnderSingleBlock(3),
                new FirstPeriodUnderSingleBlock(4)
        ));
    }


}
