package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;

import java.util.Arrays;


public class GeneralOtherBlock extends GeneralBetContainer {

    public GeneralOtherBlock() {
        super(Arrays.asList(
                new GeneralEvenScoreBlock(),
                new GeneralTotalOverAllPeriodsBlock(),
                new GeneralTotalUnderAllPeriodsBlock(),
                new GeneralBothTeamsTotalOverBlock(),
                new GeneralBothTeamsTotalUnderBlock()
        ), ContainerType.OTHER);
    }
}
