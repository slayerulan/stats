package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetWinSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetWinSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamShotsOnTargetWinPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamShotsOnTargetWinPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                   Function<HockeyMatch, Period> function) {
        super(
                new PeriodOpposingTeamShotsOnTargetWinSingleBlock(function, homeMatchData),
                new PeriodTeamShotsOnTargetWinSingleBlock(function, guestMatchData)
        );
    }
}
