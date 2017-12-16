package com.savik.blocks.hockey.match.general.stats;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamShotsOnTargetHandicapPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class TeamShotsOnTargetHandicapPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamShotsOnTargetHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, -5.5
                        ), ContainerType.MINUS_5_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, -4.5
                        ), ContainerType.MINUS_4_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, -3.5
                        ), ContainerType.MINUS_3_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, -2.5
                        ), ContainerType.MINUS_2_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, -1.5
                        ), ContainerType.MINUS_1_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 1.5
                        ), ContainerType.PLUS_1_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 2.5
                        ), ContainerType.PLUS_2_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 3.5
                        ), ContainerType.PLUS_3_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 4.5
                        ), ContainerType.PLUS_4_5
                ),
                new PossibleBetContainer<>(
                        new TeamShotsOnTargetHandicapPossibleBet(
                                homeMatchData, guestMatchData,
                                HockeyMatch.MATCH, 5.5
                        ), ContainerType.PLUS_5_5
                )
                ), ContainerType.TEAM_SHOTS_ON_TARGET_HANDICAP
        );
    }
}
