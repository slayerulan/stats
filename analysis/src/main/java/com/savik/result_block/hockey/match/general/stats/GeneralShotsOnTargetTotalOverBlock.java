package com.savik.result_block.hockey.match.general.stats;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.hockey.stats.PeriodShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralShotsOnTargetTotalOverBlock extends PeriodBetContainer {

    public GeneralShotsOnTargetTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodShotsOnTargetOverSingleBlock(58.5),
                        new PeriodShotsOnTargetOverSingleBlock(60.5),
                        new PeriodShotsOnTargetOverSingleBlock(62.5)
                ), HockeyMatch.MATCH, ContainerType.SHOTS_ON_TARGET_OVER
        );
    }
}
