package com.savik.football.blocks.handicap;

import java.util.Arrays;
import java.util.function.Function;

import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestHandicapBlock extends PeriodBetContainer {

    public PeriodGuestHandicapBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodGuestHandicapSingleBlock(1.5),
                new PeriodGuestHandicapSingleBlock(2.5),
                new PeriodGuestHandicapSingleBlock(3.5)
        ), function);
    }


}