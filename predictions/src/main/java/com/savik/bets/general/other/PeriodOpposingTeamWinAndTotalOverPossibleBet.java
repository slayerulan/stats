package com.savik.bets.general.other;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.result.PeriodOpposingTeamWinAndTotalOverBlock;
import com.savik.blocks.general.result.PeriodTeamWinAndTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamWinAndTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamWinAndTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamWinAndTotalOverBlock<>(amount, homeMatchData, function),
                new PeriodTeamWinAndTotalOverBlock<>(amount, guestMatchData, function)
        );
    }
}
