package com.savik.result_block.hockey.match.general.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.hockey.stats.PeriodPowerplayGoalsOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralPowerplayGoalsTotalOverBlock extends PeriodBetContainer {

    public GeneralPowerplayGoalsTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodPowerplayGoalsOverSingleBlock(0.5, ContainerType.OVER_0_5),
                        new PeriodPowerplayGoalsOverSingleBlock(1.5, ContainerType.OVER_1_5)
                ), HockeyMatch.MATCH, ContainerType.POWERPLAY_GOALS_OVER
        );
    }
}
