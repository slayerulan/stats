package com.savik.bets.general.total;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTotalUnderPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(new PeriodUnderSingleBlock<>(amount, function), new PeriodUnderSingleBlock<>(amount, function));
    }
}
