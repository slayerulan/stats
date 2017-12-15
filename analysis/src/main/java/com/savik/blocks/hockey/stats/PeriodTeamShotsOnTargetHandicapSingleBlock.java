package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsHandicap;
import com.savik.bets.hockey.stats.PeriodHomeShotsHandicap;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamShotsOnTargetHandicapSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamShotsOnTargetHandicapSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodHomeShotsHandicap(amount),
                new PeriodGuestShotsHandicap(amount),
                type
        );
    }

    public PeriodTeamShotsOnTargetHandicapSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeShotsHandicap(amount),
                new PeriodGuestShotsHandicap(amount),
                function,
                matchData
        );
    }

}
