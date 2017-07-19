package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodUnderBlock extends FirstPeriodBetContainer {

    public FirstPeriodUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodUnderSingleBlock(0.5),
                new FirstPeriodUnderSingleBlock(1.5),
                new FirstPeriodUnderSingleBlock(2.5),
                new FirstPeriodUnderSingleBlock(3.5),
                new FirstPeriodUnderSingleBlock(4.5)
        ));
    }


}
