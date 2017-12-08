package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodBothTeamsTotalUnderSingleBlock;

import java.util.function.Function;

public class PeriodBothTeamTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodBothTeamTotalUnderPossibleBet(Function<T, Period> function, double amount) {
        super(
                new PeriodBothTeamsTotalUnderSingleBlock<>(amount, function),
                new PeriodBothTeamsTotalUnderSingleBlock<>(amount, function)
        );
    }
}
