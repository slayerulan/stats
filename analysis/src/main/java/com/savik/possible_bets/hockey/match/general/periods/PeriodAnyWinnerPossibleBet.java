package com.savik.possible_bets.hockey.match.general.periods;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodAnyWinnerBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodAnyWinnerPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodAnyWinnerPossibleBet(Function<HockeyMatch, Period> function) {
        super(new PeriodAnyWinnerBlock<>(function), new PeriodAnyWinnerBlock<>(function));
    }
}
