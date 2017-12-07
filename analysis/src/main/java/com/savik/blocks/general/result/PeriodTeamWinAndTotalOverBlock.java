package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestWinAndTotalOver;
import com.savik.bets.general.other.PeriodHomeWinAndTotalOver;

import java.util.function.Function;


public class PeriodTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeWinAndTotalOver(total),
                new PeriodGuestWinAndTotalOver(total),
                type
        );
    }

    public PeriodTeamWinAndTotalOverBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodHomeWinAndTotalOver(total),
                new PeriodGuestWinAndTotalOver(total),
                function, matchData
        );
    }


}
