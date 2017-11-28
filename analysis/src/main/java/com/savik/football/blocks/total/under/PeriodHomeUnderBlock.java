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
public class PeriodHomeUnderBlock extends PeriodBetContainer {

    public PeriodHomeUnderBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodHomeUnderSingleBlock(0.5),
                new PeriodHomeUnderSingleBlock(1.5),
                new PeriodHomeUnderSingleBlock(2.5),
                new PeriodHomeUnderSingleBlock(3.5),
                new PeriodHomeUnderSingleBlock(4.5)
        ), function);
    }


}