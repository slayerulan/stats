package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.OpposingTeamShotsOnTargetTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class OpposingTeamShotsOnTargetTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public OpposingTeamShotsOnTargetTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new OpposingTeamShotsOnTargetTotalOverPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 28.5
                        ), ContainerType.OVER_28_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamShotsOnTargetTotalOverPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 30.5
                        ), ContainerType.OVER_30_5
                ),
                new PossibleBetContainer<>(
                        new OpposingTeamShotsOnTargetTotalOverPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 32.5
                        ), ContainerType.OVER_32_5
                )
                ), ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_OVER
        );
    }
}
