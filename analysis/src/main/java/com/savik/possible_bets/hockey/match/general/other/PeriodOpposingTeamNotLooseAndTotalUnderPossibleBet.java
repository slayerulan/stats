package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamNotLooseAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamNotLooseAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamNotLooseAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                              Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamNotLooseAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodTeamNotLooseAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
