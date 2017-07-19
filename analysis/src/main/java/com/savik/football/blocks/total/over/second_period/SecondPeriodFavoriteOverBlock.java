package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteOverBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteOverBlock() {
        super(Arrays.asList(
                new SecondPeriodFavoriteOverSingleBlock(0.5),
                new SecondPeriodFavoriteOverSingleBlock(1.5),
                new SecondPeriodFavoriteOverSingleBlock(2.5),
                new SecondPeriodFavoriteOverSingleBlock(3.5),
                new SecondPeriodFavoriteOverSingleBlock(4.5)
        ));
    }


}
