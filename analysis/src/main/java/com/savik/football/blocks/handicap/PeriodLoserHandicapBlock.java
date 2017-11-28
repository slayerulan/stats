package com.savik.football.blocks.handicap;

import com.savik.football.blocks.PeriodFavoriteBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserHandicapBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserHandicapBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodLoserHandicapSingleBlock(1.5),
                new PeriodLoserHandicapSingleBlock(2.5),
                new PeriodLoserHandicapSingleBlock(3.5)
        ), function);
    }


}
