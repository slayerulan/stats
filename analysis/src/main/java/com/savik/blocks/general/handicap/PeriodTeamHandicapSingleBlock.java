package com.savik.blocks.general.handicap;

import com.savik.*;
import com.savik.bets.general.handicap.PeriodGuestHandicap;
import com.savik.bets.general.handicap.PeriodHomeHandicap;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodTeamHandicapSingleBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamHandicapSingleBlock(double handicap, ContainerType type) {
        super(
                new PeriodHomeHandicap(handicap),
                new PeriodGuestHandicap(handicap),
                type
        );
    }

    public PeriodTeamHandicapSingleBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodHomeHandicap(total),
                new PeriodGuestHandicap(total),
                function, matchData
        );
    }

}
