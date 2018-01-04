package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamPenaltiesTimeNotLooseSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class TeamPenaltiesTimeNotLoosePossibleBet extends PossibleBet<HockeyMatch> {
    public TeamPenaltiesTimeNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                Function<HockeyMatch, Period> function) {
        super(
                new PeriodTeamPenaltiesTimeNotLooseSingleBlock(function, homeMatchData),
                new PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
