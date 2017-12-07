package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.other.PeriodGuestWinAndTotalOver;
import com.savik.bets.general.other.PeriodHomeWinAndTotalOver;


public class PeriodOpposingTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestWinAndTotalOver(total),
                new PeriodHomeWinAndTotalOver(total),
                type
        );
    }


}
