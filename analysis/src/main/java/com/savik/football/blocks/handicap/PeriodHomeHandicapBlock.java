package com.savik.football.blocks.handicap;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeHandicapBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodHomeHandicapBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodHomeHandicapSingleBlock(-2.5),
                new PeriodHomeHandicapSingleBlock(-1.5),
                new PeriodHomeHandicapSingleBlock(1.5),
                new PeriodHomeHandicapSingleBlock(2.5)
        ), function);
    }


}
