package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteHandicapBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodFavoriteHandicapSingleBlock(1),
                new FirstPeriodFavoriteHandicapSingleBlock(2),
                new FirstPeriodFavoriteHandicapSingleBlock(3)
        ));
    }


}
