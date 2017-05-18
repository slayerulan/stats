package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstGoalTimeBeforeBlock extends GeneralBetContainer {

    public FirstGoalTimeBeforeBlock() {
        super(Arrays.asList(
                new FirstGoalTimeBeforeSingleBlock(20),
                new FirstGoalTimeBeforeSingleBlock(30)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
