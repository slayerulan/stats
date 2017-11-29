package com.savik.result_block.hockey.general.other;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.under.PeriodBothTeamsTotalUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralBothTeamsTotalUnderBlock extends PeriodBetContainer {

    GeneralBothTeamsTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodBothTeamsTotalUnderSingleBlock(2.5),
                        new PeriodBothTeamsTotalUnderSingleBlock(3.5)
                ), HockeyMatch.MATCH, ContainerType.BOTH_TEAMS_TOTAL_UNDER
        );
    }
}
