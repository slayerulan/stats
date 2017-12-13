package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamWinAndTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralTeamWinAndTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamWinAndTotalUnderBlock(4.5, UNDER_4_5),
                        new PeriodTeamWinAndTotalUnderBlock(5.5, UNDER_5_5)
                ), HockeyMatch.MATCH, matchData, TEAM_WIN_AND_TOTAL_UNDER
        );
    }
}
