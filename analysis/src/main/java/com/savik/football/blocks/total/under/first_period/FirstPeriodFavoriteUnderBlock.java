package com.savik.football.blocks.total.under.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteUnderBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteUnderBlock() {
        super(Arrays.asList(
                new FirstPeriodFavoriteUnderSingleBlock(0.5),
                new FirstPeriodFavoriteUnderSingleBlock(1.5),
                new FirstPeriodFavoriteUnderSingleBlock(2.5),
                new FirstPeriodFavoriteUnderSingleBlock(3.5),
                new FirstPeriodFavoriteUnderSingleBlock(4.5)
        ));
    }


}
