package com.savik.blocks.general.total.over;

import com.savik.*;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;

import java.util.function.Function;


public class PeriodTeamTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeOver(total),
                new PeriodGuestOver(total),
                type
        );
    }

    public PeriodTeamTotalOverBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodHomeOver(total),
                new PeriodGuestOver(total),
                function, matchData
        );
    }


}
