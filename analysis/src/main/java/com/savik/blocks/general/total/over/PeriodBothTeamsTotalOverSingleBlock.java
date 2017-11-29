package com.savik.blocks.general.total.over;

import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodBothTeamsTotalOver;
import com.savik.bets.general.total.under.PeriodBothTeamsTotalUnder;


public class PeriodBothTeamsTotalOverSingleBlock extends PeriodBetContainer {

    public PeriodBothTeamsTotalOverSingleBlock(double amount) {
        super(new PeriodBothTeamsTotalOver(amount));
    }
}
