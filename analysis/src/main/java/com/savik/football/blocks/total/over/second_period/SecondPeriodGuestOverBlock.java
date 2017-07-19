package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestOverBlock extends SecondPeriodBetContainer {

    public SecondPeriodGuestOverBlock() {
        super(Arrays.asList(
                new SecondPeriodGuestOverSingleBlock(0.5),
                new SecondPeriodGuestOverSingleBlock(1.5),
                new SecondPeriodGuestOverSingleBlock(2.5),
                new SecondPeriodGuestOverSingleBlock(3.5),
                new SecondPeriodGuestOverSingleBlock(4.5)
        ));
    }


}
