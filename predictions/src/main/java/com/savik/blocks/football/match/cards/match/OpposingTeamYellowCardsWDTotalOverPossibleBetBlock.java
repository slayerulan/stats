package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class OpposingTeamYellowCardsWDTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamYellowCardsWDTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER
        );
    }
}
