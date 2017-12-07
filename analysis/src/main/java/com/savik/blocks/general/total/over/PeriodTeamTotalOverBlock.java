package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;


public class PeriodTeamTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeOver(total),
                new PeriodGuestOver(total),
                type
        );
    }


}
