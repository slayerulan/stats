package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamWinAndTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralTeamWinAndTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamWinAndTotalOverBlock(4.5, OVER_4_5),
                        new PeriodTeamWinAndTotalOverBlock(5.5, OVER_5_5)
                ), HockeyMatch.MATCH, matchData, TEAM_WIN_AND_TOTAL_OVER
        );
    }
}
