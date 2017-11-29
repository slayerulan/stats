package com.savik.blocks.general.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.bets.general.total.over.PeriodHomeOver;
import com.savik.PeriodBetContainer;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodHomeOverSingleBlock(double amount) {
        super(new PeriodHomeOver(amount));
    }

    public PeriodHomeOverSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodHomeOver(amount), function);
    }

}
