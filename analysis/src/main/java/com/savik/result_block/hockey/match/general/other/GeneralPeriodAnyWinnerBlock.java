package com.savik.result_block.hockey.match.general.other;

import com.savik.ContainerType;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.result.PeriodAnyWinner;
import com.savik.hockey.model.HockeyMatch;

import java.util.function.Function;


class GeneralPeriodAnyWinnerBlock extends PeriodBetContainer {

    public GeneralPeriodAnyWinnerBlock(Function<HockeyMatch, Period> function, ContainerType type) {
        super(
                new PeriodAnyWinner(), function, type
        );
    }
}
