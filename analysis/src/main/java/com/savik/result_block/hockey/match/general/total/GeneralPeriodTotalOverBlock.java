package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;


class GeneralPeriodTotalOverBlock extends PeriodBetContainer {

    public GeneralPeriodTotalOverBlock(Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                Arrays.asList(
                        new PeriodOverSingleBlock(0.5),
                        new PeriodOverSingleBlock(1.5)
                ), function, type)
        ;
    }
}
