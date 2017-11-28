package com.savik.football.blocks.total.over;

import java.util.Arrays;
import java.util.function.Function;

import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOverBlock extends PeriodBetContainer {

    public PeriodOverBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodOverSingleBlock(0.5),
                new PeriodOverSingleBlock(1.5),
                new PeriodOverSingleBlock(2.5),
                new PeriodOverSingleBlock(3.5),
                new PeriodOverSingleBlock(4.5)
        ), function);
    }


}
