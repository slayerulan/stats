package com.savik.football.blocks.result;

import com.savik.football.bets.result.PeriodDraw;
import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodDrawBlock extends PeriodBetContainer {

    public PeriodDrawBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodDraw(), function);
    }


}
