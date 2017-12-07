package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;

import java.util.function.Function;


public class PeriodTeamNotLooseBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamNotLooseBlock(MatchData matchData, Function<T, Period> function, ContainerType type) {
        super(
                new PeriodHomeNotLoose(),
                new PeriodGuestNotLoose(),
                type,
                function,
                matchData
        );
    }


}
