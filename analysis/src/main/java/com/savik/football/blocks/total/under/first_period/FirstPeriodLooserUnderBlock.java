package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserUnderBlock extends GeneralBetContainer {

    public FirstPeriodLooserUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodLooserUnderSingleBlock(0),
                new FirstPeriodLooserUnderSingleBlock(1),
                new FirstPeriodLooserUnderSingleBlock(2),
                new FirstPeriodLooserUnderSingleBlock(3),
                new FirstPeriodLooserUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
