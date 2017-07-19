package com.savik.football.blocks.goals.second_period;

import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodBothTeamsScoredBlock extends SecondPeriodBetContainer {

    public SecondPeriodBothTeamsScoredBlock() {
        super(new PeriodBothTeamsScored());
    }
}
