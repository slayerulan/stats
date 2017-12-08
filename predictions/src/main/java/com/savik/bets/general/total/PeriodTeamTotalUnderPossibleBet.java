package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodOpposingTeamTotalUnderBlock;
import com.savik.blocks.general.total.under.PeriodTeamTotalUnderBlock;

import java.util.function.Function;

public class PeriodTeamTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                           Function<T, Period> function, double amount) {
        super(
                new PeriodTeamTotalUnderBlock<>(amount, function, homeMatchData),
                new PeriodOpposingTeamTotalUnderBlock<>(amount, function, guestMatchData)
        );
    }
}
