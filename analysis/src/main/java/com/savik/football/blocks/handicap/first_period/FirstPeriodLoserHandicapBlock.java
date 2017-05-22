package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLoserHandicapBlock extends GeneralBetContainer {

    public FirstPeriodLoserHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodLoserHandicapSingleBlock(1.5),
                new FirstPeriodLoserHandicapSingleBlock(2.5),
                new FirstPeriodLoserHandicapSingleBlock(3.5)
        ));
    }


}
