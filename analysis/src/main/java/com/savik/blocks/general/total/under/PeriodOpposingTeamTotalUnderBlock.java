package com.savik.blocks.general.total.under;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;


public class PeriodOpposingTeamTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodOpposingTeamTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodGuestUnder(total),
                new PeriodHomeUnder(total),
                type
        );
    }


}
