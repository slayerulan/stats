package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodTeamYellowCardsWDHandicapPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class TeamYellowCardsWDHandicapPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public TeamYellowCardsWDHandicapPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, -3.5),
                        ContainerType.MINUS_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, -2.5),
                        ContainerType.MINUS_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, -1.5),
                        ContainerType.MINUS_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, 1.5),
                        ContainerType.PLUS_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, 2.5),
                        ContainerType.PLUS_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamYellowCardsWDHandicapPossibleBet(homeMatchData, guestMatchData, period, 3.5),
                        ContainerType.PLUS_3_5
                )
                ), ContainerType.TEAM_HANDICAP
        );
    }
}
