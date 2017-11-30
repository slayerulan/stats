package com.savik.result_block.hockey.general.stats;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GeneralStatsBlock extends GeneralBetContainer {

    public GeneralStatsBlock() {
        super(Arrays.asList(
                new GeneralShotsOnTargetTotalOverBlock(),
                new GeneralPenaltiesTimeTotalOverBlock(),
                new GeneralPowerplayGoalsTotalOverBlock()
        ), ContainerType.STATS);
    }
}
