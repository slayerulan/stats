package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodResultDifferenceMore;

import java.util.function.Function;


public class PeriodAnyWinAndDiffEqualsOrMoreBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodAnyWinAndDiffEqualsOrMoreBlock(int diff, ContainerType type) {
        super(new PeriodResultDifferenceMore(diff), type);
    }

    public PeriodAnyWinAndDiffEqualsOrMoreBlock(int diff, Function<T, Period> function) {
        super(new PeriodResultDifferenceMore(diff), function);
    }


}
