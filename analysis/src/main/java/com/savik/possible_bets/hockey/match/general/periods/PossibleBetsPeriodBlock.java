package com.savik.possible_bets.hockey.match.general.periods;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;
import com.savik.possible_bets.hockey.match.general.total.PeriodTeamTotalOverPossibleBet;
import com.savik.possible_bets.hockey.match.general.total.PeriodTotalOverPossibleBet;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsPeriodBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPeriodBlock(MatchData homeMatchData, MatchData guestMatchData,
                                   Function<HockeyMatch, Period> function, ContainerType type) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinnerPossibleBet(function),
                        ContainerType.ANY_WIN
                ),
                new PossibleBetContainer<>(
                        new PeriodDrawPossibleBet(function),
                        ContainerType.DRAW
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamNotLoosePossibleBet(homeMatchData, guestMatchData, function),
                        ContainerType.TEAM_NOT_LOOSE
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodTotalOverPossibleBet(function, 1.5),
                                        ContainerType.OVER_1_5
                                )
                        ),
                        ContainerType.TOTAL_OVER
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodTeamTotalOverPossibleBet(homeMatchData, guestMatchData, function, 0.5),
                                        ContainerType.OVER_0_5
                                )
                        ),
                        ContainerType.TEAM_TOTAL_OVER
                )
        ), type);
    }
}
