package com.savik.blocks.general.total.under;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodBothTeamsTotalOver;
import com.savik.bets.general.total.under.PeriodBothTeamsTotalUnder;

import java.util.function.Function;


public class PeriodBothTeamsTotalUnderSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodBothTeamsTotalUnderSingleBlock(double amount) {
        super(new PeriodBothTeamsTotalUnder(amount));
    }

    public PeriodBothTeamsTotalUnderSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodBothTeamsTotalUnder(amount), function);
    }
}
