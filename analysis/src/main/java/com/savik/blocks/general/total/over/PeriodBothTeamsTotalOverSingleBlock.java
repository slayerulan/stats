package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodBothTeamsTotalOver;

import java.util.function.Function;


public class PeriodBothTeamsTotalOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodBothTeamsTotalOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodBothTeamsTotalOver(amount), type);
    }

    public PeriodBothTeamsTotalOverSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodBothTeamsTotalOver(amount), function);
    }
}
