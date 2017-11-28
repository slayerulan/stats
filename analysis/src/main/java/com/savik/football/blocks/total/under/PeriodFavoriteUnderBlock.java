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
public class PeriodFavoriteUnderBlock extends PeriodFavoriteBetContainer {

    public PeriodFavoriteUnderBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodFavoriteUnderSingleBlock(0.5),
                new PeriodFavoriteUnderSingleBlock(1.5),
                new PeriodFavoriteUnderSingleBlock(2.5),
                new PeriodFavoriteUnderSingleBlock(3.5),
                new PeriodFavoriteUnderSingleBlock(4.5)
        ), function);
    }


}
