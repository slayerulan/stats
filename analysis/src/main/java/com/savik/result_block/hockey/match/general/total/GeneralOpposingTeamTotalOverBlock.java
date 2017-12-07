package com.savik.result_block.hockey.match.general.total;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.blocks.general.total.over.PeriodOpposingTeamTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamTotalOverBlock(1.5, OVER_1_5),
                        new PeriodOpposingTeamTotalOverBlock(2.5, OVER_2_5),
                        new PeriodOpposingTeamTotalOverBlock(3.5, OVER_3_5),
                        new PeriodOpposingTeamTotalOverBlock(4.5, OVER_4_5)
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_TOTAL_OVER
        );

    }
}
