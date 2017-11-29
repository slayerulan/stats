package com.savik.blocks.general.total.under;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.under.PeriodBothTeamsTotalUnder;


public class PeriodBothTeamsTotalUnderSingleBlock extends PeriodBetContainer {

    public PeriodBothTeamsTotalUnderSingleBlock(double amount) {
        super(new PeriodBothTeamsTotalUnder(amount));
    }
}
