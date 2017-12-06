package com.savik.blocks.general.total.over;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodOver;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodOverSingleBlock(double amount, ContainerType type) {
        super(new PeriodOver(amount), type);
    }

    public PeriodOverSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodOver(amount), function);
    }


}
