package com.savik.blocks.general.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.bets.general.total.over.PeriodGuestOver;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.total.over.PeriodHomeOver;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodGuestOverSingleBlock(double amount) {
        super(new PeriodGuestOver(amount));
    }

    public PeriodGuestOverSingleBlock(double amount, Function<T, Period> function) {
        super(new PeriodHomeOver(amount), function);
    }


}
