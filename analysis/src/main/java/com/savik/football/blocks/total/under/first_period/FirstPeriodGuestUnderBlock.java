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
                new FirstPeriodGuestUnderSingleBlock(0),
                new FirstPeriodGuestUnderSingleBlock(1),
                new FirstPeriodGuestUnderSingleBlock(2),
                new FirstPeriodGuestUnderSingleBlock(3),
                new FirstPeriodGuestUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
