package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodAnyWinAndDiffEqualsPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodAnyWinAndDiffEqualsPossibleBetBlock(Function<HockeyMatch, Period> function, int diff, ContainerType type) {
        super(
                new PeriodAnyWinAndDiffEqualsPossibleBet(function, diff), type
        );
    }
}
