package com.savik.blocks.general.handicap;

import com.savik.*;
import com.savik.bets.general.handicap.PeriodGuestHandicap;
import com.savik.bets.general.handicap.PeriodHomeHandicap;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOpposingTeamHandicapSingleBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamHandicapSingleBlock(double handicap, ContainerType type) {
        super(
                new PeriodGuestHandicap(handicap),
                new PeriodHomeHandicap(handicap),
                type
        );
    }

    public PeriodOpposingTeamHandicapSingleBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodGuestHandicap(total),
                new PeriodHomeHandicap(total),
                function, matchData
        );
    }

}
