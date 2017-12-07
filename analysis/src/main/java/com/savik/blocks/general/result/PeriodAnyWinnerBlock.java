package com.savik.blocks.general.result;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;


public class PeriodAnyWinnerBlock<T extends Match> extends PeriodBetContainer {

    public PeriodAnyWinnerBlock(Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                new PeriodAnyWinner(), function, type
        );
    }

}
