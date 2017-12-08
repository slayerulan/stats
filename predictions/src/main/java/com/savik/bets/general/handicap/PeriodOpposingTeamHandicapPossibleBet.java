package com.savik.bets.general.handicap;


import com.savik.Match;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.handicap.PeriodOpposingTeamHandicapSingleBlock;
import com.savik.blocks.general.handicap.PeriodTeamHandicapSingleBlock;

import java.util.function.Function;

public class PeriodOpposingTeamHandicapPossibleBet<T extends Match> extends PossibleBet<T> {
    public PeriodOpposingTeamHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<T, Period> function, double amount) {
        super(
                new PeriodOpposingTeamHandicapSingleBlock<>(amount, function, homeMatchData),
                new PeriodTeamHandicapSingleBlock<>(amount, function, guestMatchData)
        );
    }
}
