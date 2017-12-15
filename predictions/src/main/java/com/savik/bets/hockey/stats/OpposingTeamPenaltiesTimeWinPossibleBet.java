package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamPenaltiesTimeWinSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamPenaltiesTimeWinSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamPenaltiesTimeWinPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamPenaltiesTimeWinPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                   Function<HockeyMatch, Period> function) {
        super(
                new PeriodOpposingTeamPenaltiesTimeWinSingleBlock(function, homeMatchData),
                new PeriodTeamPenaltiesTimeWinSingleBlock(function, guestMatchData)
        );
    }
}
