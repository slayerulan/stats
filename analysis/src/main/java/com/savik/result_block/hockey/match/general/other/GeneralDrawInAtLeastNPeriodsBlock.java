package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.result.DrawAtLeastNPeriods;
import com.savik.blocks.general.result.DrawAtLeastNPeriodsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralDrawInAtLeastNPeriodsBlock extends GeneralBetContainer {

    public GeneralDrawInAtLeastNPeriodsBlock() {
        super(
                Arrays.asList(
                        new DrawAtLeastNPeriodsBlock(1, NUMBER_1),
                        new DrawAtLeastNPeriodsBlock(2, NUMBER_2)
                ), DRAW_AT_LEAST_N_PERIODS
        );
    }
}
