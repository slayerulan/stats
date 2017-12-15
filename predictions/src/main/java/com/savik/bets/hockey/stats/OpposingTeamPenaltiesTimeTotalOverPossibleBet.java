package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamPenaltiesTimeOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamPenaltiesTimeOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamPenaltiesTimeTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamPenaltiesTimeTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                         Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodOpposingTeamPenaltiesTimeOverSingleBlock(amount, function, homeMatchData),
                new PeriodTeamPenaltiesTimeOverSingleBlock(amount, function, guestMatchData)
        );
    }
}
