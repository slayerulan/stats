package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.goals.PeriodFirstGoalTimeBeforeSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralFirstGoalBeforeBlock extends PeriodBetContainer {

    public GeneralFirstGoalBeforeBlock() {
        super(
                Arrays.asList(
                        new PeriodFirstGoalTimeBeforeSingleBlock(9),
                        new PeriodFirstGoalTimeBeforeSingleBlock(10)
                ), HockeyMatch.MATCH, ContainerType.FIRST_GOAL_BEFORE
        );
    }
}
