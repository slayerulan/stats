package com.savik.blocks.hockey.match.general.periods;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.bets.general.periods.PeriodAnyWinnerPossibleBet;
import com.savik.bets.general.periods.PeriodDrawPossibleBet;
import com.savik.bets.general.periods.PeriodOpposingTeamNotLoosePossibleBet;
import com.savik.bets.general.periods.PeriodTeamNotLoosePossibleBet;
import com.savik.bets.general.total.*;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsPeriodBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPeriodBlock(MatchData homeMatchData, MatchData guestMatchData,
                                   Function<HockeyMatch, Period> function, ContainerType type) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinnerPossibleBet<>(function),
                        ContainerType.ANY_WIN
                ),
                new PossibleBetContainer<>(
                        new PeriodDrawPossibleBet<>(function),
                        ContainerType.DRAW
                ),
                new PossibleBetContainer<>(
                        new PeriodTeamNotLoosePossibleBet<>(homeMatchData, guestMatchData, function),
                        ContainerType.TEAM_NOT_LOOSE
                ),
                new PossibleBetContainer<>(
                        new PeriodOpposingTeamNotLoosePossibleBet<>(homeMatchData, guestMatchData, function),
                        ContainerType.OPPOSING_TEAM_NOT_LOOSE
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodTotalOverPossibleBet<>(function, 0.5),
                                        ContainerType.OVER_0_5
                                ),
                                new PossibleBetContainer<>(
                                        new PeriodTotalOverPossibleBet<>(function, 1.5),
                                        ContainerType.OVER_1_5
                                )
                        ),
                        ContainerType.TOTAL_OVER
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodTotalUnderPossibleBet<>(function, 1.5),
                                        ContainerType.UNDER_1_5
                                ),
                                new PossibleBetContainer<>(
                                        new PeriodTotalUnderPossibleBet<>(function, 2.5),
                                        ContainerType.UNDER_2_5
                                )
                        ),
                        ContainerType.TOTAL_UNDER
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodTeamTotalOverPossibleBet<>(homeMatchData, guestMatchData, function, 0.5),
                                        ContainerType.OVER_0_5
                                ),
                                new PossibleBetContainer<>(
                                        new PeriodTeamTotalOverPossibleBet<>(homeMatchData, guestMatchData, function, 1.5),
                                        ContainerType.OVER_1_5
                                )
                        ),
                        ContainerType.TEAM_TOTAL_OVER
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodOpposingTeamTotalOverPossibleBet<>(homeMatchData, guestMatchData, function, 0.5),
                                        ContainerType.OVER_0_5
                                ),
                                new PossibleBetContainer<>(
                                        new PeriodOpposingTeamTotalOverPossibleBet<>(homeMatchData, guestMatchData, function, 1.5),
                                        ContainerType.OVER_1_5
                                )
                        ),
                        ContainerType.OPPOSING_TEAM_TOTAL_OVER
                ),
                new PossibleBetContainer<>(
                        Arrays.asList(
                                new PossibleBetContainer<>(
                                        new PeriodBothTeamTotalOverPossibleBet<>(function, 0.5),
                                        ContainerType.OVER_0_5
                                )
                        ),
                        ContainerType.BOTH_TEAMS_TOTAL_OVER
                )
        ), type);
    }
}
