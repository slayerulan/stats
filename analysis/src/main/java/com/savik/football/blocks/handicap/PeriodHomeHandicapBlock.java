package com.savik.football.blocks.handicap;

import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeHandicapBlock extends PeriodBetContainer {

    public PeriodHomeHandicapBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodHomeHandicapSingleBlock(-2.5),
                new PeriodHomeHandicapSingleBlock(-1.5),
                new PeriodHomeHandicapSingleBlock(1.5),
                new PeriodHomeHandicapSingleBlock(2.5)
        ), function);
    }


}
