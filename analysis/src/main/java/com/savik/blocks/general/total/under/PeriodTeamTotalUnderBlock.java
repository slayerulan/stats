package com.savik.blocks.general.total.under;

import com.savik.*;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;

import java.util.function.Function;


public class PeriodTeamTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodHomeUnder(total),
                new PeriodGuestUnder(total),
                type
        );
    }

    public PeriodTeamTotalUnderBlock(double total, Function<T, Period> function, MatchData matchData) {
        super(
                new PeriodHomeUnder(total),
                new PeriodGuestUnder(total),
                function, matchData
        );
    }


}
