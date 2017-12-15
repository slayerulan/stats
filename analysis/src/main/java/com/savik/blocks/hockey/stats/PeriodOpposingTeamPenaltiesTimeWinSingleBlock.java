package com.savik.blocks.hockey.stats;

import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestPenaltiesTimeWin;
import com.savik.bets.hockey.stats.PeriodHomePenaltiesTimeWin;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamPenaltiesTimeWinSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {


    public PeriodOpposingTeamPenaltiesTimeWinSingleBlock(Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestPenaltiesTimeWin(),
                new PeriodHomePenaltiesTimeWin(),
                function,
                matchData
        );
    }

}
