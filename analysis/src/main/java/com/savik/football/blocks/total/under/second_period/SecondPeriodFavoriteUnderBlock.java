package com.savik.football.blocks.total.under.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteUnderBlock extends GeneralBetContainer {

    public SecondPeriodFavoriteUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodFavoriteUnderSingleBlock(0),
                new SecondPeriodFavoriteUnderSingleBlock(1),
                new SecondPeriodFavoriteUnderSingleBlock(2),
                new SecondPeriodFavoriteUnderSingleBlock(3),
                new SecondPeriodFavoriteUnderSingleBlock(4)
        ));
    }


}
