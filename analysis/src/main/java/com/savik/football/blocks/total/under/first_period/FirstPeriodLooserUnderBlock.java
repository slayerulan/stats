package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserUnderBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLooserUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodLooserUnderSingleBlock(0.5),
                new FirstPeriodLooserUnderSingleBlock(1.5),
                new FirstPeriodLooserUnderSingleBlock(2.5),
                new FirstPeriodLooserUnderSingleBlock(3.5),
                new FirstPeriodLooserUnderSingleBlock(4.5)
        ));
    }


}
