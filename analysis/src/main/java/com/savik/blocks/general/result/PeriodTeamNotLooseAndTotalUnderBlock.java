package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalUnder;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalUnder;

import java.util.function.Function;


public class PeriodTeamNotLooseAndTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamNotLooseAndTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodHomeNotLooseAndTotalUnder(total),
                new PeriodGuestNotLooseAndTotalUnder(total),
                type
        );
    }

    public PeriodTeamNotLooseAndTotalUnderBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodHomeNotLooseAndTotalUnder(total),
                new PeriodGuestNotLooseAndTotalUnder(total),
                function, matchData
        );
    }


}
