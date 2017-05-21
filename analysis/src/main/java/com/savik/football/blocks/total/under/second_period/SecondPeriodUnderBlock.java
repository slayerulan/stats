package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodUnderBlock extends GeneralBetContainer {

    public SecondPeriodUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodUnderSingleBlock(0),
                new SecondPeriodUnderSingleBlock(1),
                new SecondPeriodUnderSingleBlock(2),
                new SecondPeriodUnderSingleBlock(3),
                new SecondPeriodUnderSingleBlock(4)
        ));
    }


}
