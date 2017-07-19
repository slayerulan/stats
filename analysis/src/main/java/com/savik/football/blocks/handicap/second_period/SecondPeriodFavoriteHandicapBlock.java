package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteHandicapBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodFavoriteHandicapSingleBlock(1.5),
                new SecondPeriodFavoriteHandicapSingleBlock(2.5),
                new SecondPeriodFavoriteHandicapSingleBlock(3.5)
        ));
    }


}
