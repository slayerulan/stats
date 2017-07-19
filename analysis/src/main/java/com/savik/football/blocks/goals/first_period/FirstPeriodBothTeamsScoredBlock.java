package com.savik.football.blocks.goals.first_period;

import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodBothTeamsScoredBlock extends FirstPeriodBetContainer {

    public FirstPeriodBothTeamsScoredBlock() {
        super(new PeriodBothTeamsScored());
    }


}
