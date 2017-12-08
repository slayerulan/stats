package com.savik.bets.general.periods;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodDrawBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodDrawPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodDrawPossibleBet(Function<HockeyMatch, Period> function) {
        super(new PeriodDrawBlock<>(function), new PeriodDrawBlock<>(function));
    }
}
