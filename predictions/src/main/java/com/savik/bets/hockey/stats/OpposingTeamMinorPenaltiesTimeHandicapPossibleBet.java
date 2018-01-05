package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamMinorPenaltiesHandicapSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamMinorPenaltiesHandicapSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamMinorPenaltiesTimeHandicapPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamMinorPenaltiesTimeHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                             Function<HockeyMatch, Period> function, double handicap) {
        super(
                new PeriodOpposingTeamMinorPenaltiesHandicapSingleBlock(handicap, function, homeMatchData),
                new PeriodTeamMinorPenaltiesHandicapSingleBlock(handicap, function, guestMatchData)
        );
    }
}
