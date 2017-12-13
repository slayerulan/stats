package com.savik.bets.hockey.stats;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class ShotsOnTargetTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public ShotsOnTargetTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodShotsOnTargetOverSingleBlock(amount, function),
                new PeriodShotsOnTargetOverSingleBlock(amount, function)
        );
    }
}
