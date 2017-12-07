package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalOver;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalOver;


public class PeriodOpposingTeamNotLooseAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamNotLooseAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestNotLooseAndTotalOver(total),
                new PeriodHomeNotLooseAndTotalOver(total),
                type
        );
    }


}
