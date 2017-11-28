package com.savik.football.blocks.result;

import com.savik.football.bets.result.PeriodGuestWinner;
import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodGuestWinnerBlock extends PeriodBetContainer {

    public PeriodGuestWinnerBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodGuestWinner(), function);
    }


}
