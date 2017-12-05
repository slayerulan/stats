package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.goals.PeriodLastGoalTimeAfterSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.OVER_54;


class GeneralLastGoalAfterBlock extends PeriodBetContainer {

    public GeneralLastGoalAfterBlock() {
        super(
                Arrays.asList(new PeriodLastGoalTimeAfterSingleBlock(54, OVER_54)),
                HockeyMatch.MATCH, ContainerType.LAST_GOAL_AFTER
        );
    }
}