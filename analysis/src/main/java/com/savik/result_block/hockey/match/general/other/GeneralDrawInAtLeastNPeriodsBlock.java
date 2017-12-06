package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralBetContainer;
import com.savik.bets.hockey.result.DrawAtLeastNPeriods;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralDrawInAtLeastNPeriodsBlock extends GeneralBetContainer {

    public GeneralDrawInAtLeastNPeriodsBlock() {
        super(
                Arrays.asList(
                        new GeneralBetContainer<HockeyMatch>(
                                new DrawAtLeastNPeriods(1),
                                NUMBER_1
                        ),
                        new GeneralBetContainer<HockeyMatch>(
                                new DrawAtLeastNPeriods(2),
                                NUMBER_2
                        )
                ), DRAW_AT_LEAST_N_PERIODS
        );
    }
}
