package com.savik.possible_bets.hockey.match.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.under.PeriodOpposingTeamTotalUnderBlock;
import com.savik.blocks.general.total.under.PeriodTeamTotalUnderBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamTotalUnderPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamTotalUnderPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                   Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamTotalUnderBlock<>(amount, function, guestMatchData),
                new PeriodTeamTotalUnderBlock<>(amount, function, homeMatchData)
        );
    }
}
