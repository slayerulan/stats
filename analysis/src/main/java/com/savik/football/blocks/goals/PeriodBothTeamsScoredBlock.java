package com.savik.football.blocks.goals;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.football.bets.goals.PeriodBothTeamsScored;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodBothTeamsScoredBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodBothTeamsScoredBlock(Function<T, Period> function) {
        super(new PeriodBothTeamsScored(), function);
    }


}
