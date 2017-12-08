package com.savik.bets.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOpposingTeamTotalOverBlock;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                          Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamTotalOverBlock<>(amount, function, homeMatchData),
                new PeriodOpposingTeamTotalOverBlock<>(amount, function, guestMatchData)
        );
    }
}
