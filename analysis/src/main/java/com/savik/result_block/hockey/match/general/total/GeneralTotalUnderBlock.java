package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.under.PeriodUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralTotalUnderBlock extends PeriodBetContainer {

    public GeneralTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodUnderSingleBlock(3.5),
                        new PeriodUnderSingleBlock(4.5),
                        new PeriodUnderSingleBlock(5.5),
                        new PeriodUnderSingleBlock(6.5),
                        new PeriodUnderSingleBlock(7.5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_UNDER
        );
    }
}
