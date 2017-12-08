package com.savik.bets.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodOpposingTeamTotalUnderBlock;
import com.savik.blocks.general.total.under.PeriodTeamTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodTeamTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                           Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamTotalUnderBlock<>(amount, function, homeMatchData),
                new PeriodOpposingTeamTotalUnderBlock<>(amount, function, guestMatchData)
        );
    }
}
