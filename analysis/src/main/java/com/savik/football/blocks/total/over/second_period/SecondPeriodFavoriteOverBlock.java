package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteOverBlock extends GeneralBetContainer {

    public SecondPeriodFavoriteOverBlock() {
        super(Arrays.asList(
                new SecondPeriodFavoriteOverSingleBlock(0),
                new SecondPeriodFavoriteOverSingleBlock(1),
                new SecondPeriodFavoriteOverSingleBlock(2),
                new SecondPeriodFavoriteOverSingleBlock(3),
                new SecondPeriodFavoriteOverSingleBlock(4)
        ));
    }


}
