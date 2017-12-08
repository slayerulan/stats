package com.savik.bets.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalUnderBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamWinAndTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamWinAndTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                         Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamWinAndTotalUnderBlock<>(amount, homeMatchData, function),
                new PeriodTeamWinAndTotalUnderBlock<>(amount, guestMatchData, function)
        );
    }
}
