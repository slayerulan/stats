package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralTotalOverBlock extends PeriodBetContainer {

    public GeneralTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodOverSingleBlock(3.5),
                        new PeriodOverSingleBlock(4.5),
                        new PeriodOverSingleBlock(5.5),
                        new PeriodOverSingleBlock(6.5),
                        new PeriodOverSingleBlock(7.5)
                ), HockeyMatch.MATCH, ContainerType.TOTAL_OVER)
        ;
    }
}
