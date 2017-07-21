package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserOverBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLoserOverBlock() {
        super(Arrays.asList(
                new FirstPeriodLoserOverSingleBlock(0.5),
                new FirstPeriodLoserOverSingleBlock(1.5),
                new FirstPeriodLoserOverSingleBlock(2.5),
                new FirstPeriodLoserOverSingleBlock(3.5),
                new FirstPeriodLoserOverSingleBlock(4.5)
        ));
    }


}
