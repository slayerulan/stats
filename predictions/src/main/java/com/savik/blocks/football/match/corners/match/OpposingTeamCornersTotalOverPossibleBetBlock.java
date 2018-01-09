package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.corners.PeriodOpposingTeamCornersTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class OpposingTeamCornersTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamCornersTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 5.5),
                        ContainerType.OVER_5_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 6.5),
                        ContainerType.OVER_6_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamCornersTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 7.5),
                        ContainerType.OVER_7_5
                )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER
        );
    }
}
