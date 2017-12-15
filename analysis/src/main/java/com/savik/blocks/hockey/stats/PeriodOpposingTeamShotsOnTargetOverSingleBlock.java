package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestShotsOnTargetOver;
import com.savik.bets.hockey.stats.PeriodHomeShotsOnTargetOver;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

public class PeriodOpposingTeamShotsOnTargetOverSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodOpposingTeamShotsOnTargetOverSingleBlock(double amount, ContainerType type) {
        super(
                new PeriodGuestShotsOnTargetOver(amount),
                new PeriodHomeShotsOnTargetOver(amount),
                type
        );
    }

    public PeriodOpposingTeamShotsOnTargetOverSingleBlock(double amount, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodGuestShotsOnTargetOver(amount),
                new PeriodHomeShotsOnTargetOver(amount),
                function,
                matchData
        );
    }

}
