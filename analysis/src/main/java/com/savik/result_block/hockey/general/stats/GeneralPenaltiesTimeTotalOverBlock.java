package com.savik.result_block.hockey.general.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.hockey.stats.PeriodPenaltiesTimeOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralPenaltiesTimeTotalOverBlock extends PeriodBetContainer {

    public GeneralPenaltiesTimeTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodPenaltiesTimeOverSingleBlock(14.5),
                        new PeriodPenaltiesTimeOverSingleBlock(16.5)
                ), HockeyMatch.MATCH, ContainerType.PENALTIES_TIME_OVER
        );
    }
}
