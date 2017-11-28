package com.savik.football.blocks.total.under.first_period;

import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserUnderBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodLoserUnderSingleBlock(0.5),
                new FirstPeriodLoserUnderSingleBlock(1.5),
                new FirstPeriodLoserUnderSingleBlock(2.5),
                new FirstPeriodLoserUnderSingleBlock(3.5),
                new FirstPeriodLoserUnderSingleBlock(4.5)
        ));
    }


}
