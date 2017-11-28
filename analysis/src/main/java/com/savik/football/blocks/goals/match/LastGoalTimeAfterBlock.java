package com.savik.football.blocks.goals.match;

import com.savik.GeneralBetContainer;

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


}
