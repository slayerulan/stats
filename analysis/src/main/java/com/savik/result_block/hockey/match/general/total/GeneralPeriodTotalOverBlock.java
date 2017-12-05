package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

import static com.savik.ContainerType.OVER_0_5;
import static com.savik.ContainerType.OVER_1_5;


class GeneralPeriodTotalOverBlock extends PeriodBetContainer {

    public GeneralPeriodTotalOverBlock(Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                Arrays.asList(
                        new PeriodOverSingleBlock(0.5, OVER_0_5),
                        new PeriodOverSingleBlock(1.5, OVER_1_5)
                ), function, type)
        ;
    }
}
