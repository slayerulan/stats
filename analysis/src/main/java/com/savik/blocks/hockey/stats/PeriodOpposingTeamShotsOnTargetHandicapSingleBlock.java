package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsHandicap;
import com.savik.bets.hockey.stats.PeriodHomeShotsHandicap;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamShotsOnTargetHandicapSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamShotsOnTargetHandicapSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodGuestShotsHandicap(amount),
                new PeriodHomeShotsHandicap(amount),
                type
        );
    }

    public PeriodOpposingTeamShotsOnTargetHandicapSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestShotsHandicap(amount),
                new PeriodHomeShotsHandicap(amount),
                function,
                matchData
        );
    }

}
