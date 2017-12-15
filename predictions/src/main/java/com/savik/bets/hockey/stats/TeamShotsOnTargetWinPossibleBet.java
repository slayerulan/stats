package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetWinSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetWinSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamShotsOnTargetWinPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamShotsOnTargetWinPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                           Function<HockeyMatch, Period> function) {
        super(
                new PeriodTeamShotsOnTargetWinSingleBlock(function, homeMatchData),
                new PeriodOpposingTeamShotsOnTargetWinSingleBlock(function, guestMatchData)
        );
    }
}
