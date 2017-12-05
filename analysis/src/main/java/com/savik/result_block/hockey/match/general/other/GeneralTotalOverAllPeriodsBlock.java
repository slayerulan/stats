package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.blocks.hockey.goals.match.TotalOverInAllPeriodsSingleBlock;

import java.util.Arrays;


class GeneralTotalOverAllPeriodsBlock extends GeneralBetContainer {

    public GeneralTotalOverAllPeriodsBlock() {
        super(
                Arrays.asList(
                        new TotalOverInAllPeriodsSingleBlock(0.5, ContainerType.OVER_0_5)
                ), ContainerType.TOTAL_OVER_ALL_PERIODS
        );
    }
}
