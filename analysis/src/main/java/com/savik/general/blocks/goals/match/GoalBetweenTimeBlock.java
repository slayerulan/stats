package com.savik.general.blocks.goals.match;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalBetweenTimeBlock extends GeneralBetContainer<FootballMatch> {

    public GoalBetweenTimeBlock(int from, int before) {
        super(Arrays.asList(
                new GoalBetweenTimeSingleBlock(0, 16)
        ));
    }


}
