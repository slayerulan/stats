package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalOver;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalOver;

import java.util.function.Function;


public class PeriodOpposingTeamNotLooseAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamNotLooseAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestNotLooseAndTotalOver(total),
                new PeriodHomeNotLooseAndTotalOver(total),
                type
        );
    }

    public PeriodOpposingTeamNotLooseAndTotalOverBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodGuestNotLooseAndTotalOver(total),
                new PeriodHomeNotLooseAndTotalOver(total),
                function, matchData
        );
    }


}
