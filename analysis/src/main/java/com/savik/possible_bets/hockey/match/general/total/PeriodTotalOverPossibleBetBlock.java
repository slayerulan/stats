package com.savik.possible_bets.hockey.match.general.total;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBetContainer;
import com.savik.hockey.model.HockeyMatch;

import java.util.Arrays;
import java.util.function.Function;

public class PeriodTotalOverPossibleBetBlock extends PossibleBetContainer<HockeyMatch> {
    public PeriodTotalOverPossibleBetBlock(Function<HockeyMatch, Period> function, double amount, ContainerType type) {
        super(
                new PeriodTotalOverPossibleBet(function, amount), type
        );
    }
}
