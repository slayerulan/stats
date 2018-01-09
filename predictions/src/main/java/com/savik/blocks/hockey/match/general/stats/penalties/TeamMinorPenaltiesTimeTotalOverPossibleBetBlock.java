package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;

public class TeamMinorPenaltiesTimeTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamMinorPenaltiesTimeTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new TeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new TeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                ),
                new PossibleBetContainer<>(
                        new TeamPenaltiesTimeTotalOverPossibleBet(
                                homeMatchData, guestMatchData, HockeyMatch.MATCH, 8.5),
                        ContainerType.OVER_8_5
                )
                ), ContainerType.TEAM_MINOR_PENALTIES_TIME_OVER
        );
    }
}
