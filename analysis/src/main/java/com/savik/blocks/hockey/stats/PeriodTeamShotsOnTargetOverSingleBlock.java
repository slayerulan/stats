package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodTeamShotsOnTargetOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamShotsOnTargetOverSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodHomeShotsOnTargetOver(amount),
                new PeriodGuestShotsOnTargetOver(amount),
                type
        );
    }

    public PeriodTeamShotsOnTargetOverSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeShotsOnTargetOver(amount),
                new PeriodGuestShotsOnTargetOver(amount),
                function,
                matchData
        );
    }

}
