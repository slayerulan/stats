package com.savik.bets.hockey.stats;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodPenaltiesTimeOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PenaltiesTimeTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PenaltiesTimeTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodPenaltiesTimeOverSingleBlock(amount, function),
                new PeriodPenaltiesTimeOverSingleBlock(amount, function)
        );
    }
}
