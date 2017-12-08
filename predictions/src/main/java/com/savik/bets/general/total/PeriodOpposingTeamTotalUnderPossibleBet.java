package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodOpposingTeamTotalUnderBlock;
import com.savik.blocks.general.total.under.PeriodTeamTotalUnderBlock;

import java.util.function.Function;

public class PeriodOpposingTeamTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                   Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamTotalUnderBlock<>(amount, function, homeMatchData),
                new PeriodTeamTotalUnderBlock<>(amount, function, guestMatchData)
        );
    }
}
