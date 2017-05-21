package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLoserHandicapBlock extends GeneralBetContainer {

    public SecondPeriodLoserHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodLoserHandicapSingleBlock(1),
                new SecondPeriodLoserHandicapSingleBlock(2),
                new SecondPeriodLoserHandicapSingleBlock(3)
        ));
    }


}
