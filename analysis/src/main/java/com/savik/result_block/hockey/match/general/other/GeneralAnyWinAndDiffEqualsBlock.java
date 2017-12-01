package com.savik.result_block.hockey.match.general.other;

import com.savik.PeriodBetContainer;
import com.savik.blocks.general.result.PeriodAnyWinAndDiffEqualsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS;


class GeneralAnyWinAndDiffEqualsBlock extends PeriodBetContainer {

    public GeneralAnyWinAndDiffEqualsBlock() {
        super(
                Arrays.asList(
                        new PeriodAnyWinAndDiffEqualsBlock<HockeyMatch>(1),
                        new PeriodAnyWinAndDiffEqualsBlock<HockeyMatch>(2)
                ), HockeyMatch.MATCH, ANY_WIN_AND_DIFFERENCE_EQUALS
        );
    }
}
