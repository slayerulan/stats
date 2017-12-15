package com.savik.blocks.general.other;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.other.PeriodAnyComeback;

import java.util.function.Function;

public class PeriodAnyComebackSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodAnyComebackSingleBlock(ContainerType type) {
        super(new PeriodAnyComeback(), type);
    }

    public PeriodAnyComebackSingleBlock(Function<T, Period> function) {
        super(new PeriodAnyComeback(), function);
    }

}
