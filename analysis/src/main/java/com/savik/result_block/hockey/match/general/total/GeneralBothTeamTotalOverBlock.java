package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.OVER_1_5;
import static com.savik.ContainerType.OVER_2_5;


class GeneralBothTeamTotalOverBlock extends PeriodBetContainer {

    public GeneralBothTeamTotalOverBlock() {
        super(
                Arrays.asList(
                        new PeriodBothTeamsTotalOverSingleBlock(1.5, OVER_1_5),
                        new PeriodBothTeamsTotalOverSingleBlock(2.5, OVER_2_5)
                ), HockeyMatch.MATCH, ContainerType.BOTH_TEAMS_TOTAL_OVER)
        ;
    }
}
