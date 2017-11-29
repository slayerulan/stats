package com.savik.blocks.football.goals.match;

import com.savik.bets.football.goals.match.GoalBetweenTime;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalBetweenTimeSingleBlock extends GeneralBetContainer<FootballMatch> {

    public GoalBetweenTimeSingleBlock(int from, int before) {
        super(new GoalBetweenTime(from, before));
    }


}