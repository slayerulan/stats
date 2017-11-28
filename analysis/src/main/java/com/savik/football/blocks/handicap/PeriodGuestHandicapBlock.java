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
public class PeriodGuestHandicapBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGuestHandicapBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodGuestHandicapSingleBlock(1.5),
                new PeriodGuestHandicapSingleBlock(2.5),
                new PeriodGuestHandicapSingleBlock(3.5)
        ), function);
    }


}
