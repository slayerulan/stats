package com.savik.football.blocks.total.over;

import com.savik.Match;
import com.savik.Period;
import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

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
