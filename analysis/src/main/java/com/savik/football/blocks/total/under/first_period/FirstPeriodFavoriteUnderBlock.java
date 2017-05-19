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
                new FirstPeriodFavoriteUnderSingleBlock(0),
                new FirstPeriodFavoriteUnderSingleBlock(1),
                new FirstPeriodFavoriteUnderSingleBlock(2),
                new FirstPeriodFavoriteUnderSingleBlock(3),
                new FirstPeriodFavoriteUnderSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
