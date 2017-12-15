package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsHandicapOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsHandicapOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamShotsOnTargetHandicapSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamShotsOnTargetHandicapSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodHomeShotsHandicapOver(amount),
                new PeriodGuestShotsHandicapOver(amount),
                type
        );
    }

    public PeriodTeamShotsOnTargetHandicapSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeShotsHandicapOver(amount),
                new PeriodGuestShotsHandicapOver(amount),
                function,
                matchData
        );
    }

}
