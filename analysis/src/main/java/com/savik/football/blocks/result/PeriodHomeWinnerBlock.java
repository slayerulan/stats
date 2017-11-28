package com.savik.football.blocks.result;

import com.savik.football.bets.result.PeriodHomeWinner;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeWinnerBlock extends PeriodBetContainer {

    public PeriodHomeWinnerBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodHomeWinner(), function);
    }


}
