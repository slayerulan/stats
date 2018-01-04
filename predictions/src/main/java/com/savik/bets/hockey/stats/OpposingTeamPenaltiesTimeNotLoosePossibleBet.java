package com.savik.bets.hockey.stats;


import com.savik.MatchData;
import com.savik.Period;
import com.savik.PossibleBet;
import com.savik.blocks.hockey.stats.PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock;
import com.savik.blocks.hockey.stats.PeriodTeamPenaltiesTimeNotLooseSingleBlock;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class OpposingTeamPenaltiesTimeNotLoosePossibleBet extends PossibleBet<HockeyMatch> {
    public OpposingTeamPenaltiesTimeNotLoosePossibleBet(MatchData homeMatchData, MatchData guestMatchData,
                                                        Function<HockeyMatch, Period> function) {
        super(
                new PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock(function, homeMatchData),
                new PeriodTeamPenaltiesTimeNotLooseSingleBlock(function, guestMatchData)
        );
    }
}
