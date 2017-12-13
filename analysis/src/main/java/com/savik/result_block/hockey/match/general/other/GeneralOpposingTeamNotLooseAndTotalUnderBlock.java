package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamNotLooseAndTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamNotLooseAndTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamNotLooseAndTotalUnderBlock(4.5, UNDER_4_5),
                        new PeriodOpposingTeamNotLooseAndTotalUnderBlock(5.5, UNDER_5_5)
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER
        );
    }
}
