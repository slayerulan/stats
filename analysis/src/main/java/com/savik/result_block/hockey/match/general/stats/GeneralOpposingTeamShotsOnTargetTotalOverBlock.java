package com.savik.result_block.hockey.match.general.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

import static com.savik.ContainerType.OVER_28_5;
import static com.savik.ContainerType.OVER_30_5;


class GeneralOpposingTeamShotsOnTargetTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralOpposingTeamShotsOnTargetTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodOpposingTeamShotsOnTargetOverSingleBlock(28.5, OVER_28_5),
                        new PeriodOpposingTeamShotsOnTargetOverSingleBlock(30.5, OVER_30_5)
                ),
                HockeyMatch.MATCH,
                matchData,
                ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_OVER
        );
    }
}
