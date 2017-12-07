package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestWinAndTotalUnder;
import com.savik.bets.general.other.PeriodHomeWinAndTotalUnder;

import java.util.function.Function;


public class PeriodTeamWinAndTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamWinAndTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodHomeWinAndTotalUnder(total),
                new PeriodGuestWinAndTotalUnder(total),
                type
        );
    }

    public PeriodTeamWinAndTotalUnderBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodHomeWinAndTotalUnder(total),
                new PeriodGuestWinAndTotalUnder(total),
                function, matchData
        );
    }


}
