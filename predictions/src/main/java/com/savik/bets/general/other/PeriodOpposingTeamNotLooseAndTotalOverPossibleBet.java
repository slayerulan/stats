package com.savik.bets.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamNotLooseAndTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamNotLooseAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                             Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamNotLooseAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodTeamNotLooseAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
