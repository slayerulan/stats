package com.savik.bets.general.total;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOpposingTeamTotalOverBlock;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;

import java.util.function.Function;

public class PeriodOpposingTeamTotalOverPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                  Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamTotalOverBlock<>(amount, function, homeMatchData),
                new PeriodTeamTotalOverBlock<>(amount, function, guestMatchData )
        );
    }
}
