package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOpposingTeamTotalOverBlock;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;

import java.util.function.Function;

public class PeriodTeamTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                          Function<T, Period> function, double amount) {
        super(
                new PeriodTeamTotalOverBlock<>(amount, function, homeMatchData),
                new PeriodOpposingTeamTotalOverBlock<>(amount, function, guestMatchData)
        );
    }
}
