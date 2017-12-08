package com.savik.bets.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamNotLooseAndTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamNotLooseAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                     Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamNotLooseAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodOpposingTeamNotLooseAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
