package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLooserUnderBlock extends GeneralBetContainer {

    public SecondPeriodLooserUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodLooserUnderSingleBlock(0.5),
                new SecondPeriodLooserUnderSingleBlock(1.5),
                new SecondPeriodLooserUnderSingleBlock(2.5),
                new SecondPeriodLooserUnderSingleBlock(3.5),
                new SecondPeriodLooserUnderSingleBlock(4.5)
        ));
    }


}
