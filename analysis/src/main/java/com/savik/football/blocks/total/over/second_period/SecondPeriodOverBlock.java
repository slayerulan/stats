package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodOverBlock extends GeneralBetContainer {

    public SecondPeriodOverBlock() {
        super(Arrays.asList(
                new SecondPeriodOverSingleBlock(0),
                new SecondPeriodOverSingleBlock(1),
                new SecondPeriodOverSingleBlock(2),
                new SecondPeriodOverSingleBlock(3),
                new SecondPeriodOverSingleBlock(4)
        ));
    }


}
