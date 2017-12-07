package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.other.PeriodGuestWinAndTotalOver;
import com.savik.bets.general.other.PeriodHomeWinAndTotalOver;


public class PeriodTeamWinAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamWinAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeWinAndTotalOver(total),
                new PeriodGuestWinAndTotalOver(total),
                type
        );
    }


}
