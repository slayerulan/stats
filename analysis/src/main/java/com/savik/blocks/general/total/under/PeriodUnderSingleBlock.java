package com.savik.blocks.general.total.under;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.under.PeriodUnder;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodUnderSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodUnderSingleBlock(double amount, ContainerType type) {
        super(new PeriodUnder(amount), type);
    }

    public PeriodUnderSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodUnder(amount), function);
    }


}
