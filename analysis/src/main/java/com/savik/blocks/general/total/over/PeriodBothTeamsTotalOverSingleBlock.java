package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodBothTeamsTotalOver;


public class PeriodBothTeamsTotalOverSingleBlock extends PeriodBetContainer {

    public PeriodBothTeamsTotalOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodBothTeamsTotalOver(amount), type);
    }
}
