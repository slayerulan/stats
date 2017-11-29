package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.blocks.hockey.goals.match.TotalOverInAllPeriodsSingleBlock;

import java.util.Arrays;


class GeneralTotalOverAllPeriodsBlock extends GeneralBetContainer {

    public GeneralTotalOverAllPeriodsBlock() {
        super(
                Arrays.asList(
                        new TotalOverInAllPeriodsSingleBlock(0.5),
                        new TotalOverInAllPeriodsSingleBlock(1.5)
                ), ContainerType.TOTAL_OVER_ALL_PERIODS
        );
    }
}
