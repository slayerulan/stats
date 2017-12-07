package com.savik.result_block.hockey.match.general.other;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamNotLooseAndTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralTeamNotLooseAndTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamNotLooseAndTotalOverBlock(4.5, OVER_4_5),
                        new PeriodTeamNotLooseAndTotalOverBlock(5.5, OVER_5_5)
                ), HockeyMatch.MATCH, matchData, TEAM_NOT_LOOSE_AND_TOTAL_OVER
        );
    }
}
