package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodOverBlock extends SecondPeriodBetContainer {

    public SecondPeriodOverBlock() {
        super(Arrays.asList(
                new SecondPeriodOverSingleBlock(0.5),
                new SecondPeriodOverSingleBlock(1.5),
                new SecondPeriodOverSingleBlock(2.5),
                new SecondPeriodOverSingleBlock(3.5),
                new SecondPeriodOverSingleBlock(4.5)
        ));
    }


}
