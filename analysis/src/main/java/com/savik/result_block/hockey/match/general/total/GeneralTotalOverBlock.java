package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTotalOverBlock extends PeriodBetContainer {

    public GeneralTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodOverSingleBlock(4.5, OVER_4_5),
                        new PeriodOverSingleBlock(5.5, OVER_5_5),
                        new PeriodOverSingleBlock(6.5, OVER_6_5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_OVER)
        ;
    }
}
