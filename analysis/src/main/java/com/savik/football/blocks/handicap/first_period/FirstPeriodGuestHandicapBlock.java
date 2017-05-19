package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodGuestHandicapBlock extends GeneralBetContainer {

    public FirstPeriodGuestHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodGuestHandicapSingleBlock(1),
                new FirstPeriodGuestHandicapSingleBlock(2),
                new FirstPeriodGuestHandicapSingleBlock(3)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
