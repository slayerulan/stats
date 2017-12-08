package com.savik.bets.general.periods;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseBlock;

import java.util.function.Function;

public class PeriodTeamNotLoosePossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodTeamNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                         Function<T, Period> function) {
        super(
                new PeriodTeamNotLooseBlock<>(homeMatchData, function),
                new PeriodOpposingTeamNotLooseBlock<>(guestMatchData, function)
        );
    }
}
