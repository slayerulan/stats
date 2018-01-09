package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodTeamYellowCardsWDTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class TeamYellowCardsWDTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamYellowCardsWDTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, FootballMatch.MATCH, 4.5),
                        ContainerType.OVER_4_5
                )
                ), ContainerType.TEAM_TOTAL_OVER
        );
    }
}