package com.savik.blocks.football.match.cards.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.football.cards.PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;
import java.util.function.Function;

public class OpposingTeamYellowCardsWDTotalOverPossibleBetBlock extends PossibleBetContainer<FootballMatch> {
    public OpposingTeamYellowCardsWDTotalOverPossibleBetBlock(MatchData homeMatchData, MatchData guestMatchData, Function<FootballMatch, Period> period) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, period, 1.5),
                        ContainerType.OVER_1_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, period, 2.5),
                        ContainerType.OVER_2_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, period, 3.5),
                        ContainerType.OVER_3_5
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamYellowCardsWDTotalOverPossibleBet(homeMatchData, guestMatchData, period, 4.5),
                        ContainerType.OVER_4_5
                )
                ), ContainerType.OPPOSING_TEAM_TOTAL_OVER
        );
    }
}
