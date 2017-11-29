package com.savik.general.blocks.handicap;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodFavoriteBetContainer;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserHandicapBlock<T extends Match> extends PeriodFavoriteBetContainer {

    public PeriodLoserHandicapBlock(Function<T, Period> function) {
        super(Arrays.asList(
                new PeriodLoserHandicapSingleBlock(1.5),
                new PeriodLoserHandicapSingleBlock(2.5),
                new PeriodLoserHandicapSingleBlock(3.5)
        ), function);
    }


}
