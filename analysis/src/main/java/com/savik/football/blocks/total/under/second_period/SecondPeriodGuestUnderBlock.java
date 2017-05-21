package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestUnderBlock extends GeneralBetContainer {

    public SecondPeriodGuestUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodGuestUnderSingleBlock(0),
                new SecondPeriodGuestUnderSingleBlock(1),
                new SecondPeriodGuestUnderSingleBlock(2),
                new SecondPeriodGuestUnderSingleBlock(3),
                new SecondPeriodGuestUnderSingleBlock(4)
        ));
    }


}
