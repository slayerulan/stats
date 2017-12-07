package com.savik.possible_bets.hockey.match.general.total;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.general.total.over.PeriodOpposingTeamTotalOverBlock;
import com.savik.blocks.general.total.over.PeriodTeamTotalOverBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public PeriodOpposingTeamTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                  Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamTotalOverBlock<>(amount, function, homeMatchData),
                new PeriodTeamTotalOverBlock<>(amount, function, guestMatchData )
        );
    }
}
