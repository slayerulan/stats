package com.savik.blocks.general.total.under;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodTeamBetContainer;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.bets.general.total.under.PeriodGuestUnder;
import com.savik.bets.general.total.under.PeriodHomeUnder;


public class PeriodTeamTotalUnderBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamTotalUnderBlock(double total, ContainerType type) {
        super(
                new PeriodHomeUnder(total),
                new PeriodGuestUnder(total),
                type
        );
    }


}
