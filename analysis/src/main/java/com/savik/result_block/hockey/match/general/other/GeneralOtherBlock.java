package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GeneralOtherBlock extends GeneralBetContainer {

    public GeneralOtherBlock() {
        super(Arrays.asList(
                new GeneralTotalOverAllPeriodsBlock(),
                new GeneralTotalUnderAllPeriodsBlock(),
                new GeneralAnyWinAndTotalOverBlock(),
                new GeneralAnyWinAndTotalUnderBlock(),
                new GeneralAnyWinAndDiffEqualsBlock()
        ), ContainerType.OTHER);
    }
}
