package com.savik.football.blocks.handicap;

import com.savik.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodFavoriteHandicapBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteHandicapBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodFavoriteHandicapSingleBlock(1.5),
                new PeriodFavoriteHandicapSingleBlock(2.5),
                new PeriodFavoriteHandicapSingleBlock(3.5)
        ), function);
    }


}
