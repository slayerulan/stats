package com.savik.result_block.hockey.match.general.total;

import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;
import com.savik.blocks.general.total.under.PeriodOpposingTeamTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralOpposingTeamTotalUnderBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamTotalUnderBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamTotalUnderBlock(2.5, UNDER_2_5),
                        new PeriodOpposingTeamTotalUnderBlock(3.5, UNDER_3_5),
                        new PeriodOpposingTeamTotalUnderBlock(4.5, UNDER_4_5)
                ), HockeyMatch.MATCH, matchData, OPPOSING_TEAM_TOTAL_UNDER
        );

    }
}
