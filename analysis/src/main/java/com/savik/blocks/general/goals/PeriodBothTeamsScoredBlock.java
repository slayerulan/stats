package com.savik.blocks.general.goals;

import com.savik.Match;
import com.savik.Period;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.goals.PeriodBothTeamsScored;

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
