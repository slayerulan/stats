package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.goals.PeriodLastGoalTimeAfterSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralLastGoalBeforeBlock extends PeriodBetContainer {

    public GeneralLastGoalBeforeBlock() {
        super(
                Arrays.asList(new PeriodLastGoalTimeAfterSingleBlock(55)),
                HockeyMatch.MATCH, ContainerType.LAST_GOAL_AFTER
        );
    }
}
