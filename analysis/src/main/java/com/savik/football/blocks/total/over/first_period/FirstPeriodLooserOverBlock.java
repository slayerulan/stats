package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserOverBlock extends GeneralBetContainer {

    public FirstPeriodLooserOverBlock() {
        super(Arrays.asList(
                new FirstPeriodLooserOverSingleBlock(0.5),
                new FirstPeriodLooserOverSingleBlock(1.5),
                new FirstPeriodLooserOverSingleBlock(2.5),
                new FirstPeriodLooserOverSingleBlock(3.5),
                new FirstPeriodLooserOverSingleBlock(4.5)
        ));
    }


}
