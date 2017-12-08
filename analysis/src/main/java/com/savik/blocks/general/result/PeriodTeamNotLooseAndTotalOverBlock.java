package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalOver;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalOver;

import java.util.function.Function;


public class PeriodTeamNotLooseAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamNotLooseAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeNotLooseAndTotalOver(total),
                new PeriodGuestNotLooseAndTotalOver(total),
                type
        );
    }

    public PeriodTeamNotLooseAndTotalOverBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodHomeNotLooseAndTotalOver(total),
                new PeriodGuestNotLooseAndTotalOver(total),
                function, matchData
        );
    }


}
