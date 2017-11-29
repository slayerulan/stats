package com.savik.result_block.hockey.home.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodHomeOverSingleBlock;
import com.savik.blocks.general.total.under.PeriodHomeUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class HomeTotalUnderBlock extends PeriodBetContainer {


    public HomeTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodHomeUnderSingleBlock(2.5),
                        new PeriodHomeUnderSingleBlock(3.5),
                        new PeriodHomeUnderSingleBlock(4.5),
                        new PeriodHomeUnderSingleBlock(5.5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_UNDER
        );
    }
}
