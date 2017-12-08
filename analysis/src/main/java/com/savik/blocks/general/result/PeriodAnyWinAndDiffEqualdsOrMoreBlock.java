package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodResultDifferenceMore;

import java.util.function.Function;


public class PeriodAnyWinAndDiffEqualdsOrMoreBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodAnyWinAndDiffEqualdsOrMoreBlock(int diff, ContainerType type) {
        super(new PeriodResultDifferenceMore(diff), type);
    }

    public PeriodAnyWinAndDiffEqualdsOrMoreBlock(int diff, Function<T, Period> function) {
        super(new PeriodResultDifferenceMore(diff), function);
    }


}
