package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamWinAndTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamWinAndTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamWinAndTotalUnderBlock(4.5, UNDER_4_5),
                        new PeriodOpposingTeamWinAndTotalUnderBlock(5.5, UNDER_5_5)
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_WIN_AND_TOTAL_UNDER
        );
    }
}
