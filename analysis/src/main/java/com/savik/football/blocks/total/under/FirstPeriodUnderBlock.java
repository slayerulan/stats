package com.savik.football.blocks.total.under;

import java.util.Arrays;
import java.util.function.Function;

import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodUnderBlock extends PeriodBetContainer {

    public FirstPeriodUnderBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodUnderSingleBlock(0.5),
                new PeriodUnderSingleBlock(1.5),
                new PeriodUnderSingleBlock(2.5),
                new PeriodUnderSingleBlock(3.5),
                new PeriodUnderSingleBlock(4.5)
        ), function);
    }


}
