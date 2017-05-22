package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestUnderBlock extends GeneralBetContainer {

    public FirstPeriodGuestUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodGuestUnderSingleBlock(0.5),
                new FirstPeriodGuestUnderSingleBlock(1.5),
                new FirstPeriodGuestUnderSingleBlock(2.5),
                new FirstPeriodGuestUnderSingleBlock(3.5),
                new FirstPeriodGuestUnderSingleBlock(4.5)
        ));
    }


}
