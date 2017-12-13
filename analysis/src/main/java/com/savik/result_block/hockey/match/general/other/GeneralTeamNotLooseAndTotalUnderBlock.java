package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamNotLooseAndTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralTeamNotLooseAndTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamNotLooseAndTotalUnderBlock(4.5, UNDER_4_5),
                        new PeriodTeamNotLooseAndTotalUnderBlock(5.5, UNDER_5_5)
                ), HockeyMatch.MATCH, matchData, TEAM_NOT_LOOSE_AND_TOTAL_UNDER
        );
    }
}
