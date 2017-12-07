package com.savik.possible_bets.hockey.match.general.other;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.blocks.general.other.PeriodWinAndOverSingleBlock;
import com.savik.blocks.general.other.PeriodWinAndUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodAnyWinAndTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodAnyWinAndTotalUnderPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodWinAndUnderSingleBlock<>(amount, new PeriodAnyWinner(), function),
                new PeriodWinAndUnderSingleBlock<>(amount, new PeriodAnyWinner(), function)
        );
    }
}
