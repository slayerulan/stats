package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.BothTeamsScored;
import com.savik.football.bets.goals.match.GoalBetweenTime;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredBlock extends GeneralBetContainer {

    public BothTeamsScoredBlock() {
        super(new BothTeamsScored());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
