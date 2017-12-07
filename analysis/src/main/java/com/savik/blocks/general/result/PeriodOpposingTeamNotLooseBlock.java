package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;

import java.util.function.Function;


public class PeriodOpposingTeamNotLooseBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamNotLooseBlock(MatchData matchData, Function<T, Period> function, ContainerType type) {
        super(
                new PeriodGuestNotLoose(),
                new PeriodHomeNotLoose(),
                type,
                function,
                matchData
        );
    }

    public PeriodOpposingTeamNotLooseBlock(MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodGuestNotLoose(),
                new PeriodHomeNotLoose(),
                function,
                matchData
        );
    }


}
