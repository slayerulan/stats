package com.savik.blocks.hockey.stats;

import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestPenaltiesTimeOver;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamPenaltiesTimeOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamPenaltiesTimeOverSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestPenaltiesTimeOver(amount),
                new PeriodHomePenaltiesTimeOver(amount),
                function,
                matchData
        );
    }

}
