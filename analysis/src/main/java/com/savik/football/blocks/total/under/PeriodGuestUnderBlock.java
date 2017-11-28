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
public class PeriodGuestUnderBlock extends PeriodBetContainer {

    public PeriodGuestUnderBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodGuestUnderSingleBlock(0.5),
                new PeriodGuestUnderSingleBlock(1.5),
                new PeriodGuestUnderSingleBlock(2.5),
                new PeriodGuestUnderSingleBlock(3.5),
                new PeriodGuestUnderSingleBlock(4.5)
        ), function);
    }


}
