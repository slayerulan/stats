package com.savik.bets.general.total;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodBothTeamTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodBothTeamTotalOverPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodBothTeamsTotalOverSingleBlock<>(amount, function),
                new PeriodBothTeamsTotalOverSingleBlock<>(amount, function)
        );
    }
}
