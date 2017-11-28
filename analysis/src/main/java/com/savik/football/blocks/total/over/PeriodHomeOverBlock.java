package com.savik.football.blocks.total.over;

import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeOverBlock extends PeriodBetContainer {

    public PeriodHomeOverBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodHomeOverSingleBlock(0.5),
                new PeriodHomeOverSingleBlock(1.5),
                new PeriodHomeOverSingleBlock(2.5),
                new PeriodHomeOverSingleBlock(3.5),
                new PeriodHomeOverSingleBlock(4.5)
        ), function);
    }


}
