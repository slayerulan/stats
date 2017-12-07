package com.savik.possible_bets.hockey.match.general.other;


import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodAnyWinAndTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodAnyWinAndTotalOverPossibleBetBlock(Function<HockeyMatch, Period> function, double amount, ContainerType type) {
        super(
                new PeriodAnyWinAndTotalOverPossibleBet(function, amount), type
        );
    }
}
