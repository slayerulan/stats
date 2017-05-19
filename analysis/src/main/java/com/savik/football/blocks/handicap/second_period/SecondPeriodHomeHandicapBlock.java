package com.savik.football.blocks.handicap.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeHandicapBlock extends GeneralBetContainer {

    public SecondPeriodHomeHandicapBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeHandicapSingleBlock(1),
                new SecondPeriodHomeHandicapSingleBlock(2),
                new SecondPeriodHomeHandicapSingleBlock(3)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
