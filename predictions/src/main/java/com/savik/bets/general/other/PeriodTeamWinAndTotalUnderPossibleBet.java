package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalUnderBlock;

import java.util.function.Function;

public class PeriodTeamWinAndTotalUnderPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamWinAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<T, Period> function, double amount) {
        super(
                new PeriodTeamWinAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodOpposingTeamWinAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
