package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LastGoalTimeAfterBlock extends GeneralBetContainer {

    public LastGoalTimeAfterBlock() {
        super(Arrays.asList(
                new LastGoalTimeAfterSingleBlock(60),
                new LastGoalTimeAfterSingleBlock(75)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
