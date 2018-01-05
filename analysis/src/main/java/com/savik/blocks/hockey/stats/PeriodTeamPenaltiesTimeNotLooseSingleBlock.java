package com.savik.blocks.hockey.stats;

import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestMinorPenaltiesTimeNotLoose;
import com.savik.bets.hockey.stats.PeriodHomeMinorPenaltiesTimeNotLoose;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamPenaltiesTimeNotLooseSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamPenaltiesTimeNotLooseSingleBlock(Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeMinorPenaltiesTimeNotLoose(),
                new PeriodGuestMinorPenaltiesTimeNotLoose(),
                function,
                matchData
        );
    }

}
