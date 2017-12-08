package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;

import java.util.function.Function;

public class PeriodBothTeamTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodBothTeamTotalOverPossibleBet(Function<T, Period> function, double amount) {
        super(
                new PeriodBothTeamsTotalOverSingleBlock<>(amount, function),
                new PeriodBothTeamsTotalOverSingleBlock<>(amount, function)
        );
    }
}
