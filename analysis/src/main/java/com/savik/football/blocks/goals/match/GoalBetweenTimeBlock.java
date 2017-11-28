package com.savik.football.blocks.goals.match;

import com.savik.football.blocks.GeneralBetContainer;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalBetweenTimeBlock extends GeneralBetContainer {

    public GoalBetweenTimeBlock(int from, int before) {
        super(Arrays.asList(
                new GoalBetweenTimeSingleBlock(0, 16)
        ));
    }


}
