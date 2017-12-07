package com.savik.possible_bets.hockey.match.general.total;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(new PeriodOverSingleBlock<>(amount, function), new PeriodOverSingleBlock<>(amount, function));
    }
}
