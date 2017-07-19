package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodUnderBlock extends SecondPeriodBetContainer {

    public SecondPeriodUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodUnderSingleBlock(0.5),
                new SecondPeriodUnderSingleBlock(1.5),
                new SecondPeriodUnderSingleBlock(2.5),
                new SecondPeriodUnderSingleBlock(3.5),
                new SecondPeriodUnderSingleBlock(4.5)
        ));
    }


}
