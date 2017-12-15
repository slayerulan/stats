package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetWin;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetWin;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamShotsOnTargetWinSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamShotsOnTargetWinSingleBlock(ContainerType type) {
        super(
                new PeriodHomeShotsOnTargetWin(),
                new PeriodGuestShotsOnTargetWin(),
                type
        );
    }

    public PeriodTeamShotsOnTargetWinSingleBlock(Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeShotsOnTargetWin(),
                new PeriodGuestShotsOnTargetWin(),
                function,
                matchData
        );
    }

}
