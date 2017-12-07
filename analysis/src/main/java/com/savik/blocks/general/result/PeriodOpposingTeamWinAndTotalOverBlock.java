package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestWinAndTotalOver;
import com.savik.bets.general.other.PeriodHomeWinAndTotalOver;

import java.util.function.Function;


public class PeriodOpposingTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestWinAndTotalOver(total),
                new PeriodHomeWinAndTotalOver(total),
                type
        );
    }

    public PeriodOpposingTeamWinAndTotalOverBlock(double total, MatchData matchData, Function<T, Period> function) {
        super(
                new PeriodGuestWinAndTotalOver(total),
                new PeriodHomeWinAndTotalOver(total),
                function, matchData
        );
    }


}
