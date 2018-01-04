package com.savik.blocks.hockey.stats;

import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestPenaltiesTimeNotLoose;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeNotLoose;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {


    public PeriodOpposingTeamPenaltiesTimeNotLooseSingleBlock(Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestPenaltiesTimeNotLoose(),
                new PeriodHomePenaltiesTimeNotLoose(),
                function,
                matchData
        );
    }

}
