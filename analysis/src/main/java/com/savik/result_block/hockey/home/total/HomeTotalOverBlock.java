package com.savik.result_block.hockey.home.total;

import com.savik.ContainerType;
import com.savik.GeneralBetContainer;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodHomeOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;


class HomeTotalOverBlock extends PeriodBetContainer {


    public HomeTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodHomeOverSingleBlock(2.5),
                        new PeriodHomeOverSingleBlock(3.5),
                        new PeriodHomeOverSingleBlock(4.5),
                        new PeriodHomeOverSingleBlock(5.5)
                ), HockeyMatch.MATCH, ContainerType.HOME_TOTAL_OVER
        );
    }
}
