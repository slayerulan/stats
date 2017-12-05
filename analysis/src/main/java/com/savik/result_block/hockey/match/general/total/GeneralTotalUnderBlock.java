package com.savik.result_block.hockey.match.general.total;

import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.under.PeriodUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTotalUnderBlock extends PeriodBetContainer {

    public GeneralTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodUnderSingleBlock(4.5, UNDER_4_5),
                        new PeriodUnderSingleBlock(5.5, UNDER_5_5),
                        new PeriodUnderSingleBlock(6.5, UNDER_6_5),
                        new PeriodUnderSingleBlock(7.5, UNDER_7_5)
                ), HockeyMatch.MATCH, TOTAL_UNDER
        );
    }
}
