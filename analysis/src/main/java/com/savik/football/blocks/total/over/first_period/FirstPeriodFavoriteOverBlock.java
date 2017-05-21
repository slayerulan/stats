package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteOverBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteOverBlock() {
        super(Arrays.asList(
                new FirstPeriodFavoriteOverSingleBlock(0),
                new FirstPeriodFavoriteOverSingleBlock(1),
                new FirstPeriodFavoriteOverSingleBlock(2),
                new FirstPeriodFavoriteOverSingleBlock(3),
                new FirstPeriodFavoriteOverSingleBlock(4)
        ));
    }


}
