package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.under.PeriodBothTeamsTotalUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.UNDER_2_5;
import static com.savik.ContainerType.UNDER_3_5;


class GeneralBothTeamTotalUnderBlock extends PeriodBetContainer {

    public GeneralBothTeamTotalUnderBlock() {
        super(
                Arrays.asList(
                        new PeriodBothTeamsTotalUnderSingleBlock(2.5, UNDER_2_5),
                        new PeriodBothTeamsTotalUnderSingleBlock(3.5, UNDER_3_5)
                ), HockeyMatch.MATCH, ContainerType.BOTH_TEAMS_TOTAL_UNDER)
        ;
    }
}
