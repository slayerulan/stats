package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestWinAndTotalUnder;
import com.savik.bets.general.other.PeriodHomeWinAndTotalUnder;

import java.util.function.Function;


public class PeriodOpposingTeamWinAndTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamWinAndTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodGuestWinAndTotalUnder(total),
                new PeriodHomeWinAndTotalUnder(total),
                type
        );
    }

    public PeriodOpposingTeamWinAndTotalUnderBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodGuestWinAndTotalUnder(total),
                new PeriodHomeWinAndTotalUnder(total),
                function, matchData
        );
    }


}
