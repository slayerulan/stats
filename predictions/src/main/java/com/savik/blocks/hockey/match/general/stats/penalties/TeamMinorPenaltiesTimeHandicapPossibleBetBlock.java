package com.savik.blocks.hockey.match.general.stats.penalties;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.hockey.stats.TeamMinorPenaltiesTimeHandicapPossibleBet;
import com.savik.bets.hockey.stats.TeamPenaltiesTimeTotalOverPossibleBet;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class TeamMinorPenaltiesTimeHandicapPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public TeamMinorPenaltiesTimeHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData,
                                                          Function<HockeyMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, period, 4.5),
                        ContainerType.PLUS_4_5
                ),
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, period, 2.5),
                        ContainerType.PLUS_2_5
                ),
                new PossibleBetContainer<>(
                        new TeamMinorPenaltiesTimeHandicapPossibleBet(
                                homeMatchData, guestMatchData, period, -2.5),
                        ContainerType.MINUS_2_5
                )
                ), ContainerType.TEAM_MINOR_PENALTIES_TIME_HANDICAP
        );
    }
}
