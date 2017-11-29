package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;
import com.savik.blocks.general.total.under.PeriodBothTeamsTotalUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralBothTeamsTotalOverBlock extends PeriodBetContainer {

    GeneralBothTeamsTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodBothTeamsTotalOverSingleBlock(1.5),
                        new PeriodBothTeamsTotalOverSingleBlock(2.5)
                ), HockeyMatch.MATCH, ContainerType.BOTH_TEAMS_TOTAL_OVER
        );
    }
}
