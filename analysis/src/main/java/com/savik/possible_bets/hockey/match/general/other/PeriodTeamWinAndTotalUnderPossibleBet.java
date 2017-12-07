package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodTeamWinAndTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamWinAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamWinAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodOpposingTeamWinAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
