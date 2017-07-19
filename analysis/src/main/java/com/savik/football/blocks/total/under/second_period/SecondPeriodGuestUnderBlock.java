package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestUnderBlock extends SecondPeriodBetContainer {

    public SecondPeriodGuestUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodGuestUnderSingleBlock(0.5),
                new SecondPeriodGuestUnderSingleBlock(1.5),
                new SecondPeriodGuestUnderSingleBlock(2.5),
                new SecondPeriodGuestUnderSingleBlock(3.5),
                new SecondPeriodGuestUnderSingleBlock(4.5)
        ));
    }


}
