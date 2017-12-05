package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.goals.PeriodFirstGoalTimeBeforeSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.UNDER_10;
import static com.savik.ContainerType.UNDER_9;


class GeneralFirstGoalBeforeBlock extends PeriodBetContainer {

    public GeneralFirstGoalBeforeBlock() {
        super(
                Arrays.asList(
                        new PeriodFirstGoalTimeBeforeSingleBlock(9, UNDER_9),
                        new PeriodFirstGoalTimeBeforeSingleBlock(10, UNDER_10)
                ), HockeyMatch.MATCH, ContainerType.FIRST_GOAL_BEFORE
        );
    }
}
