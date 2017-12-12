package com.savik.bets.general.periods;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseBlock;

import java.util.function.Function;

public class PeriodOpposingTeamNotLoosePossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<T, Period> function) {
        super(
                new PeriodOpposingTeamNotLooseBlock<>(homeMatchData, function),
                new PeriodTeamNotLooseBlock<>(guestMatchData, function)
        );
    }
}
