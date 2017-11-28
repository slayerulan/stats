package com.savik.football.blocks.goals;

import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballPeriod;

import java.util.function.Function;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodBothTeamsScoredBlock extends PeriodBetContainer {

    public PeriodBothTeamsScoredBlock(Function<FootballMatch, FootballPeriod> function) {
        super(new PeriodBothTeamsScored(), function);
    }


}
