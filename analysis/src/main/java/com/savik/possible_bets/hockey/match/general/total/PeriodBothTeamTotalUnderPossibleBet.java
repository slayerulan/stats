package com.savik.possible_bets.hockey.match.general.total;


import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodBothTeamsTotalOverSingleBlock;
import com.savik.blocks.general.total.under.PeriodBothTeamsTotalUnderSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodBothTeamTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodBothTeamTotalUnderPossibleBet(Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodBothTeamsTotalUnderSingleBlock<>(amount, function),
                new PeriodBothTeamsTotalUnderSingleBlock<>(amount, function)
        );
    }
}
