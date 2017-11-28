package com.savik.football.blocks.total.under.second_period;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodFavoriteUnderBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodFavoriteUnderBlock() {
        super(Arrays.asList(
                new SecondPeriodFavoriteUnderSingleBlock(0.5),
                new SecondPeriodFavoriteUnderSingleBlock(1.5),
                new SecondPeriodFavoriteUnderSingleBlock(2.5),
                new SecondPeriodFavoriteUnderSingleBlock(3.5),
                new SecondPeriodFavoriteUnderSingleBlock(4.5)
        ));
    }


}
