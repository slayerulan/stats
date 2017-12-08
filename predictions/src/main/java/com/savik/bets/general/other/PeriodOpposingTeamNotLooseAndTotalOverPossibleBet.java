package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;

import java.util.function.Function;

public class PeriodOpposingTeamNotLooseAndTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamNotLooseAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                             Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamNotLooseAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodTeamNotLooseAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
