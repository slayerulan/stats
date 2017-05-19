package com.savik.football.blocks.total.over.second_period;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeOverBlock extends GeneralBetContainer {

    public SecondPeriodHomeOverBlock() {
        super(Arrays.asList(
                new SecondPeriodHomeOverSingleBlock(0),
                new SecondPeriodHomeOverSingleBlock(1),
                new SecondPeriodHomeOverSingleBlock(2),
                new SecondPeriodHomeOverSingleBlock(3),
                new SecondPeriodHomeOverSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
