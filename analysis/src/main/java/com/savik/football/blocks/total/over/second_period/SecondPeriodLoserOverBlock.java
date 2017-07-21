package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserOverBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserOverBlock() {
        super(Arrays.asList(
                new SecondPeriodLoserOverSingleBlock(0.5),
                new SecondPeriodLoserOverSingleBlock(1.5),
                new SecondPeriodLoserOverSingleBlock(2.5),
                new SecondPeriodLoserOverSingleBlock(3.5),
                new SecondPeriodLoserOverSingleBlock(4.5)
        ));
    }


}
