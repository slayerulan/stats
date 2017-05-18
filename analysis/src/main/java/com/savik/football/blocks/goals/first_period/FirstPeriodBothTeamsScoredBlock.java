package com.savik.football.blocks.goals.first_period;

import com.savik.football.bets.goals.first_period.FirstPeriodBothTeamsScored;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodBothTeamsScoredBlock extends GeneralBetContainer {

    public FirstPeriodBothTeamsScoredBlock() {
        super(new FirstPeriodBothTeamsScored());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
