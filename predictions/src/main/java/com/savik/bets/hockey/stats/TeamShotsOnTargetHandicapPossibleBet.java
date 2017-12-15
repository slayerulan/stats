package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetHandicapSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetHandicapSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamShotsOnTargetHandicapPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamShotsOnTargetHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamShotsOnTargetHandicapSingleBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamShotsOnTargetHandicapSingleBlock(amount, function, guestMatchData)
        );
    }
}
