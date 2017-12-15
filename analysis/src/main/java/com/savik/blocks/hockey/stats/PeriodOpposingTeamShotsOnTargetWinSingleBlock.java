package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetWin;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetWin;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamShotsOnTargetWinSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamShotsOnTargetWinSingleBlock(ContainerType type) {
        super(
                new PeriodGuestShotsOnTargetWin(),
                new PeriodHomeShotsOnTargetWin(),
                type
        );
    }

    public PeriodOpposingTeamShotsOnTargetWinSingleBlock(Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestShotsOnTargetWin(),
                new PeriodHomeShotsOnTargetWin(),
                function,
                matchData
        );
    }

}
