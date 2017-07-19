package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserHandicapBlock extends SecondPeriodFavoriteBetContainer {

    public SecondPeriodLoserHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodLoserHandicapSingleBlock(1.5),
                new SecondPeriodLoserHandicapSingleBlock(2.5),
                new SecondPeriodLoserHandicapSingleBlock(3.5)
        ));
    }


}
