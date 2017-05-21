package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLooserOverBlock extends GeneralBetContainer {

    public SecondPeriodLooserOverBlock() {
        super(Arrays.asList(
                new SecondPeriodLooserOverSingleBlock(0),
                new SecondPeriodLooserOverSingleBlock(1),
                new SecondPeriodLooserOverSingleBlock(2),
                new SecondPeriodLooserOverSingleBlock(3),
                new SecondPeriodLooserOverSingleBlock(4)
        ));
    }


}
