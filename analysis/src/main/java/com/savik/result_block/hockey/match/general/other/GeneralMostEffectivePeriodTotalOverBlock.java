package com.savik.result_block.hockey.match.general.other;

import com.savik.GeneralBetContainer;
import com.savik.blocks.hockey.goals.match.MostEffectivePeriodTotalOverSingleBlock;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralMostEffectivePeriodTotalOverBlock extends GeneralBetContainer {

    public GeneralMostEffectivePeriodTotalOverBlock() {
        super(
                Arrays.asList(
                        new MostEffectivePeriodTotalOverSingleBlock(2.5, OVER_2_5),
                        new MostEffectivePeriodTotalOverSingleBlock(3.5, OVER_3_5)
                ), MOST_EFFECTIVE_PERIOD_TOTAL_OVER
        );
    }
}
