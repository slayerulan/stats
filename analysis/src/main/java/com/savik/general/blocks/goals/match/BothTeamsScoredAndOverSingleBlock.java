package com.savik.general.blocks.goals.match;

import com.savik.football.bets.goals.match.BothTeamsScoredAndOver;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndOverSingleBlock extends GeneralBetContainer<FootballMatch> {

    public BothTeamsScoredAndOverSingleBlock(double amount) {
        super(new BothTeamsScoredAndOver(amount));
    }


}
