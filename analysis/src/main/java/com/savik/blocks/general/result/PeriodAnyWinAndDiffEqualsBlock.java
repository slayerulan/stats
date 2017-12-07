package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodResultDifference;

import java.util.function.Function;


public class PeriodAnyWinAndDiffEqualsBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodAnyWinAndDiffEqualsBlock(int diff, ContainerType type) {
        super(new PeriodResultDifference(diff), type);
    }

    public PeriodAnyWinAndDiffEqualsBlock(int diff, Function<T, Period> function) {
        super(new PeriodResultDifference(diff), function);
    }



}
