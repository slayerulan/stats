package com.savik.football.blocks.total.over.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteOverBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodFavoriteOverBlock() {
        super(Arrays.asList(
                new FirstPeriodFavoriteOverSingleBlock(0.5),
                new FirstPeriodFavoriteOverSingleBlock(1.5),
                new FirstPeriodFavoriteOverSingleBlock(2.5),
                new FirstPeriodFavoriteOverSingleBlock(3.5),
                new FirstPeriodFavoriteOverSingleBlock(4.5)
        ));
    }


}
