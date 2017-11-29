package com.savik.general.blocks.result;

import com.savik.Match;
import com.savik.Period;
import com.savik.bets.general.result.PeriodGuestWinner;
import com.savik.PeriodBetContainer;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestWinnerBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGuestWinnerBlock(Function<T, Period> function) {
        super(new PeriodGuestWinner(), function);
    }


}
