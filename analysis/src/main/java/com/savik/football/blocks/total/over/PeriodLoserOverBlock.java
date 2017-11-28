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
public class PeriodLoserOverBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserOverBlock(Function<FootballMatch, FootballPeriod> function) {
        super(Arrays.asList(
                new PeriodLoserOverSingleBlock(0.5),
                new PeriodLoserOverSingleBlock(1.5),
                new PeriodLoserOverSingleBlock(2.5),
                new PeriodLoserOverSingleBlock(3.5),
                new PeriodLoserOverSingleBlock(4.5)
        ), function);
    }


}
