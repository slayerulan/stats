package com.savik.football.blocks.total.over;

import com.savik.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteOverBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteOverBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodFavoriteOverSingleBlock(0.5),
                new PeriodFavoriteOverSingleBlock(1.5),
                new PeriodFavoriteOverSingleBlock(2.5),
                new PeriodFavoriteOverSingleBlock(3.5),
                new PeriodFavoriteOverSingleBlock(4.5)
        ), function);
    }


}
