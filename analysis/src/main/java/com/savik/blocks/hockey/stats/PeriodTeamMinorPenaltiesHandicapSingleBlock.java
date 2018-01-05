package com.savik.blocks.hockey.stats;

import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.Period;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.hockey.stats.PeriodGuestMinorPenaltiesTimeHandicap;
import com.savik.bets.hockey.stats.PeriodHomeMinorPenaltiesTimeHandicap;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodTeamMinorPenaltiesHandicapSingleBlock extends PeriodTeamBetContainer<HockeyMatch> {

    public PeriodTeamMinorPenaltiesHandicapSingleBlock(double handicap, ContainerType type) {
        super(
                new PeriodHomeMinorPenaltiesTimeHandicap(handicap),
                new PeriodGuestMinorPenaltiesTimeHandicap(handicap),
                type
        );
    }

    public PeriodTeamMinorPenaltiesHandicapSingleBlock(double handicap, Function<HockeyMatch, Period> function, MatchData matchData) {
        super(
                new PeriodHomeMinorPenaltiesTimeHandicap(handicap),
                new PeriodGuestMinorPenaltiesTimeHandicap(handicap),
                function, matchData
        );
    }

}
