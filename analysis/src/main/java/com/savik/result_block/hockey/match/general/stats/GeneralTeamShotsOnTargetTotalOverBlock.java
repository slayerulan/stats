package com.savik.result_block.hockey.match.general.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PeriodBetContainer;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.blocks.hockey.stats.PeriodShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;


class GeneralTeamShotsOnTargetTotalOverBlock extends PeriodTeamBetContainer {

    public GeneralTeamShotsOnTargetTotalOverBlock(MatchData matchData) {
        super(
                Arrays.asList(
                        new PeriodTeamBetContainer(
                                new PeriodHomeShotsOnTargetOver(28.5),
                                new PeriodGuestShotsOnTargetOver(28.5),
                                ContainerType.OVER_28_5
                        ),
                        new PeriodTeamBetContainer(
                                new PeriodHomeShotsOnTargetOver(30.5),
                                new PeriodGuestShotsOnTargetOver(30.5),
                                ContainerType.OVER_30_5
                        )
                ),
                HockeyMatch.MATCH,
                matchData,
                ContainerType.TEAM_SHOTS_ON_TARGET_OVER
        );
    }
}
