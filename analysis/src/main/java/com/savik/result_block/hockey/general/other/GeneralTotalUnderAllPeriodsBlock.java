package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.blocks.hockey.goals.match.TotalUnderInAllPeriodsSingleBlock;

import java.util.Arrays;


class GeneralTotalUnderAllPeriodsBlock extends GeneralBetContainer {

    public GeneralTotalUnderAllPeriodsBlock() {
        super(
                Arrays.asList(
                        new TotalUnderInAllPeriodsSingleBlock(2.5),
                        new TotalUnderInAllPeriodsSingleBlock(3.5)
                ), ContainerType.TOTAL_UNDER_ALL_PERIODS
        );
    }
}
