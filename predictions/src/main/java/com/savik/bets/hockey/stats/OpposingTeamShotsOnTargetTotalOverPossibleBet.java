package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamShotsOnTargetOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamShotsOnTargetOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamShotsOnTargetTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamShotsOnTargetTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                         Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamShotsOnTargetOverSingleBlock(amount, function, homeMatchData),
                new PeriodTeamShotsOnTargetOverSingleBlock(amount, function, guestMatchData)
        );
    }
}
