package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;

import java.util.function.Function;

public class PeriodTeamNotLooseAndTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamNotLooseAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                     Function<T, Period> function, double amount) {
        super(
                new PeriodTeamNotLooseAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodOpposingTeamNotLooseAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
