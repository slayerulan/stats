package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamPenaltiesTimeOverSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamPenaltiesTimeOverSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamPenaltiesTimeTotalOverPossibleBet extends PossibleBet<HockeyMatch> {
    public TeamPenaltiesTimeTotalOverPossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                 Function<HockeyMatch, Period> function, double amount) {
        super(
                new PeriodTeamPenaltiesTimeOverSingleBlock(amount, function, homeMatchData),
                new PeriodOpposingTeamPenaltiesTimeOverSingleBlock(amount, function, guestMatchData)
        );
    }
}
