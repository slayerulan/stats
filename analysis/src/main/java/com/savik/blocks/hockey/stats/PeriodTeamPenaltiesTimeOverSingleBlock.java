package com.savik.blocks.hockey.stats;

import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestPenaltiesTimeOver;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamPenaltiesTimeOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamPenaltiesTimeOverSingleBlock(double amount) {
        super(
                new PeriodHomePenaltiesTimeOver(amount),
                new PeriodGuestPenaltiesTimeOver(amount)
        );
    }

    public PeriodTeamPenaltiesTimeOverSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomePenaltiesTimeOver(amount),
                new PeriodGuestPenaltiesTimeOver(amount),
                function,
                matchData
        );
    }

}
