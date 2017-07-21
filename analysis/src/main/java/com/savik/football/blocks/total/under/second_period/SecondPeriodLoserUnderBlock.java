package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserUnderBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodLoserUnderSingleBlock(0.5),
                new SecondPeriodLoserUnderSingleBlock(1.5),
                new SecondPeriodLoserUnderSingleBlock(2.5),
                new SecondPeriodLoserUnderSingleBlock(3.5),
                new SecondPeriodLoserUnderSingleBlock(4.5)
        ));
    }


}
