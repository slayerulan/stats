package com.savik.football.blocks.handicap.first_period;

import java.util.Arrays;

import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeHandicapBlock extends FirstPeriodBetContainer {

    public FirstPeriodHomeHandicapBlock() {
        super(Arrays.asList(
                new FirstPeriodHomeHandicapSingleBlock(-2.5),
                new FirstPeriodHomeHandicapSingleBlock(-1.5),
                new FirstPeriodHomeHandicapSingleBlock(1.5),
                new FirstPeriodHomeHandicapSingleBlock(2.5)
        ));
    }


}
