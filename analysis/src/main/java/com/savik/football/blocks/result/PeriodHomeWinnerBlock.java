package com.savik.football.blocks.result;

import com.savik.Match;
import com.savik.Period;
import com.savik.football.bets.result.PeriodHomeWinner;
import com.savik.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

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
