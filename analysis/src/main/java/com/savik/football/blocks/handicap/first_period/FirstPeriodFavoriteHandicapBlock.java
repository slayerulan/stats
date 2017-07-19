package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteHandicapBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodFavoriteHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodFavoriteHandicapSingleBlock(1.5),
                new FirstPeriodFavoriteHandicapSingleBlock(2.5),
                new FirstPeriodFavoriteHandicapSingleBlock(3.5)
        ));
    }


}
