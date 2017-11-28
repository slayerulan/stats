package com.savik.football.blocks.total.under;

import com.savik.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserUnderBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserUnderBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodLoserUnderSingleBlock(0.5),
                new PeriodLoserUnderSingleBlock(1.5),
                new PeriodLoserUnderSingleBlock(2.5),
                new PeriodLoserUnderSingleBlock(3.5),
                new PeriodLoserUnderSingleBlock(4.5)
        ), function);
    }


}
