package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodGuestHandicapBlock extends GeneralBetContainer {

    public SecondPeriodGuestHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodGuestHandicapSingleBlock(1),
                new SecondPeriodGuestHandicapSingleBlock(2),
                new SecondPeriodGuestHandicapSingleBlock(3)
        ));
    }


}
