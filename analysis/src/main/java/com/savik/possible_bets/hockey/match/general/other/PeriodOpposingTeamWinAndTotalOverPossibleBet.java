package com.savik.possible_bets.hockey.match.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

class PeriodOpposingTeamWinAndTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamWinAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamWinAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodTeamWinAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
