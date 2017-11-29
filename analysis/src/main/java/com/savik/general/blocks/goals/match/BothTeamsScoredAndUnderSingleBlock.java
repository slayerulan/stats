package com.savik.general.blocks.goals.match;

import com.savik.football.bets.goals.match.BothTeamsScoredAndUnder;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndUnderSingleBlock extends GeneralBetContainer<FootballMatch> {

    public BothTeamsScoredAndUnderSingleBlock(double amount) {
        super(new BothTeamsScoredAndUnder(amount));
    }


}
