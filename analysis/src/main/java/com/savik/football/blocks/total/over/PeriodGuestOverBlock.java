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
public class PeriodGuestOverBlock extends PeriodBetContainer {

    public PeriodGuestOverBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodGuestOverSingleBlock(0.5),
                new PeriodGuestOverSingleBlock(1.5),
                new PeriodGuestOverSingleBlock(2.5),
                new PeriodGuestOverSingleBlock(3.5),
                new PeriodGuestOverSingleBlock(4.5)
        ), function);
    }


}
