package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalUnder;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalUnder;

import java.util.function.Function;


public class PeriodOpposingTeamNotLooseAndTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamNotLooseAndTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodGuestNotLooseAndTotalUnder(total),
                new PeriodHomeNotLooseAndTotalUnder(total),
                type
        );
    }

    public PeriodOpposingTeamNotLooseAndTotalUnderBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodGuestNotLooseAndTotalUnder(total),
                new PeriodHomeNotLooseAndTotalUnder(total),
                function, matchData
        );
    }


}
