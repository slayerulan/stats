package com.savik.blocks.general.total.over;

import com.savik.*;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;

import java.util.function.Function;


public class PeriodOpposingTeamTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestOver(total),
                new PeriodHomeOver(total),
                type
        );
    }

    public PeriodOpposingTeamTotalOverBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodGuestOver(total),
                new PeriodHomeOver(total),
                function, matchData
        );
    }


}
