package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalUnderBlock;

import java.util.function.Function;

public class PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                              Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamNotLooseAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodTeamNotLooseAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
