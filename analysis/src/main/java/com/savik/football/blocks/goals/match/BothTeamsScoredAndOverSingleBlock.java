package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.BothTeamsScoredAndOver;
import com.savik.football.bets.goals.match.GoalBetweenTime;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndOverSingleBlock extends GeneralBetContainer {

    public BothTeamsScoredAndOverSingleBlock(int amount) {
        super(new BothTeamsScoredAndOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
