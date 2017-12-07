package com.savik.result_block.hockey.match.general.total;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.total.under.PeriodTeamTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralTeamTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamTotalUnderBlock(2.5, UNDER_2_5),
                        new PeriodTeamTotalUnderBlock(3.5, UNDER_3_5),
                        new PeriodTeamTotalUnderBlock(4.5, UNDER_4_5)
                ), HockeyMatch.MATCH, matchData, TEAM_TOTAL_UNDER
        );

    }
}
