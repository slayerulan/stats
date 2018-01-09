package com.savik.blocks.hockey.match.general.stats.penalties.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamMinorPenaltiesTimeHandicapPossibleBet;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class TeamMinorPenaltiesTimeHandicapPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamMinorPenaltiesTimeHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 4.5),
                        ContainerType.PLUS_4_5
                ),
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 2.5),
                        ContainerType.PLUS_2_5
                ),
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, -2.5),
                        ContainerType.MINUS_2_5
                )
                ), ContainerType.TEAM_MINOR_PENALTIES_TIME_HANDICAP
        );
    }
}
