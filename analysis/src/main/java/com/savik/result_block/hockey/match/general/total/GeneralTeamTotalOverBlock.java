package com.savik.result_block.hockey.match.general.total;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.*;


class GeneralTeamTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralTeamTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamTotalOverBlock(1.5, OVER_1_5),
                        new PeriodTeamTotalOverBlock(2.5, OVER_2_5),
                        new PeriodTeamTotalOverBlock(3.5, OVER_3_5),
                        new PeriodTeamTotalOverBlock(4.5, OVER_4_5)
                ), HockeyMatch.MATCH, matchData, TEAM_TOTAL_OVER
        );

    }
}
