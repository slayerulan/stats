package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamNotLooseAndTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamNotLooseAndTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamNotLooseAndTotalOverBlock(4.5, OVER_4_5),
                        new PeriodOpposingTeamNotLooseAndTotalOverBlock(5.5, OVER_5_5)
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER
        );
    }
}
