package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalUnderBlock;

import java.util.function.Function;

public class PeriodOpposingTeamWinAndTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamWinAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                         Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamWinAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodTeamWinAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
