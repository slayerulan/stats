package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamMinorPenaltiesHandicapSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamMinorPenaltiesHandicapSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamMinorPenaltiesTimeHandicapPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamMinorPenaltiesTimeHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                     Function<HockeyMatch, Period> function, double handicap) {
        super(
                new PeriodTeamMinorPenaltiesHandicapSingleBlock(handicap, function, homeMatchData),
                new PeriodOpposingTeamMinorPenaltiesHandicapSingleBlock(handicap, function, guestMatchData)
        );
    }
}
