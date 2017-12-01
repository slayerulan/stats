package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;


class GeneralBothTeamsTotalOverBlock extends PeriodBetContainer {

    GeneralBothTeamsTotalOverBlock(Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                Arrays.asList(
                        new PeriodBothTeamsTotalOverSingleBlock(0.5)
                ), function, type
        );
    }
}
