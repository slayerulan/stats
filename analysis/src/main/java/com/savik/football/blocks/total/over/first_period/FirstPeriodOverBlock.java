package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodOverBlock extends FirstPeriodBetContainer {

    public FirstPeriodOverBlock() {
        super(Arrays.asList(
                new FirstPeriodOverSingleBlock(0.5),
                new FirstPeriodOverSingleBlock(1.5),
                new FirstPeriodOverSingleBlock(2.5),
                new FirstPeriodOverSingleBlock(3.5),
                new FirstPeriodOverSingleBlock(4.5)
        ));
    }


}
