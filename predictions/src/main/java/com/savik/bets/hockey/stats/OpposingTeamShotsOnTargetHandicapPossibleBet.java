package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetHandicapSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetHandicapSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamShotsOnTargetHandicapPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamShotsOnTargetHandicapPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamShotsOnTargetHandicapSingleBlock(amount, function, homeMatchData),
                new PeriodTeamShotsOnTargetHandicapSingleBlock(amount, function, guestMatchData)
        );
    }
}
