package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestOverBlock extends GeneralBetContainer {

    public FirstPeriodGuestOverBlock() {
        super(Arrays.asList(
                new FirstPeriodGuestOverSingleBlock(0.5),
                new FirstPeriodGuestOverSingleBlock(1.5),
                new FirstPeriodGuestOverSingleBlock(2.5),
                new FirstPeriodGuestOverSingleBlock(3.5),
                new FirstPeriodGuestOverSingleBlock(4.5)
        ));
    }


}
