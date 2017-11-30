package com.savik.result_block.hockey.general.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.hockey.stats.PeriodPenaltiesTimeOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodPowerplayGoalsOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralPowerplayGoalsTotalOverBlock extends PeriodBetContainer {

    public GeneralPowerplayGoalsTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodPowerplayGoalsOverSingleBlock(0.5),
                        new PeriodPowerplayGoalsOverSingleBlock(1.5)
                ), HockeyMatch.MATCH, ContainerType.POWERPLAY_GOALS_OVER
        );
    }
}
