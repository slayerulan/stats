package com.savik.bets.general.other;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalOverBlock;

import java.util.function.Function;

public class PeriodOpposingTeamWinAndTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamWinAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamWinAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodTeamWinAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
