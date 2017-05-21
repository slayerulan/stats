package com.savik.football.blocks.goals.second_period;

import com.savik.football.bets.goals.second_period.SecondPeriodBothTeamsScored;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodBothTeamsScoredBlock extends GeneralBetContainer {

    public SecondPeriodBothTeamsScoredBlock() {
        super(new SecondPeriodBothTeamsScored());
    }


}
