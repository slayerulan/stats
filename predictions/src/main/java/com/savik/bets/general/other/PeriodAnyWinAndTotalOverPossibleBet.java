package com.savik.bets.general.other;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodAnyWinAndTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodAnyWinAndTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodWinAndOverSingleBlock<>(amount, new PeriodAnyWinner(), function),
                new PeriodWinAndOverSingleBlock<>(amount, new PeriodAnyWinner(), function)
        );
    }
}
