package com.savik.blocks.general.result;

import com.savik.Match;
import com.savik.Period;
import com.savik.bets.general.result.PeriodHomeWinner;
import com.savik.PeriodBetContainer;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeWinnerBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodHomeWinnerBlock(Function<T, Period> function) {
        super(new PeriodHomeWinner(), function);
    }


}
