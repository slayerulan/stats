package com.savik.possible_bets.hockey.match.general.periods;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;
import com.savik.possible_bets.hockey.match.general.total.*;

import java.util.Arrays;
import java.util.function.Function;

public class PossibleBetsPeriodBlock extends PossibleBetContainer<HockeyMatch> {
    public PossibleBetsPeriodBlock(MatchData homeMatchData, MatchData guestMatchData,
                                   Function<HockeyMatch, Period> function, ContainerType type) {
        super(Arrays.asList(
                new PossibleBetContainer<>(
                        new PeriodAnyWinnerPossibleBet(function),
                        ContainerType.ANY_WIN
                )
        ), type);
    }
}
