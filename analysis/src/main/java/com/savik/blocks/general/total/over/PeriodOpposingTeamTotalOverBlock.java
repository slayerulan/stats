package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;


public class PeriodOpposingTeamTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodGuestOver(total),
                new PeriodHomeOver(total),
                type
        );
    }


}
