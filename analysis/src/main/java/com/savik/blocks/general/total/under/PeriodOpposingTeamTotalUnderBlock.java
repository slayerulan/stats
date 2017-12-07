package com.savik.blocks.general.total.under;

import com.savik.*;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;

import java.util.function.Function;


public class PeriodOpposingTeamTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodGuestUnder(total),
                new PeriodHomeUnder(total),
                type
        );
    }

    public PeriodOpposingTeamTotalUnderBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodGuestUnder(total),
                new PeriodHomeUnder(total),
                function, matchData
        );
    }


}
