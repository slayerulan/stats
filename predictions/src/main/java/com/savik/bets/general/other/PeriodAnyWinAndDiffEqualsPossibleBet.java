package com.savik.bets.general.other;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodAnyWinAndDiffEqualsBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodAnyWinAndDiffEqualsPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodAnyWinAndDiffEqualsPossibleBet(Function<HockeyMatch, Period> function, int diff) {
        super(
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function),
                new PeriodAnyWinAndDiffEqualsBlock<>(diff, function)
        );
    }
}
