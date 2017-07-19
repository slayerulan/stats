package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeHandicapBlock extends SecondPeriodBetContainer {

    public SecondPeriodHomeHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeHandicapSingleBlock(-2.5),
                new SecondPeriodHomeHandicapSingleBlock(-1.5),
                new SecondPeriodHomeHandicapSingleBlock(1.5),
                new SecondPeriodHomeHandicapSingleBlock(2.5)
        ));
    }


}
