package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodOpposingTeamYellowCardsWDHandicapPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class OpposingTeamYellowCardsWDHandicapPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamYellowCardsWDHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, -3.5),
                        ContainerType.MINUS_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, -2.5),
                        ContainerType.MINUS_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, -1.5),
                        ContainerType.MINUS_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 1.5),
                        ContainerType.PLUS_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.PLUS_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.PLUS_3_5
                )
                ), ContainerType.OPPOSING_TEAM_HANDICAP
        );
    }
}
