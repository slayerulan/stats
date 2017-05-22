package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.BothTeamsScoredAndUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredAndUnderSingleBlock extends GeneralBetContainer {

    public BothTeamsScoredAndUnderSingleBlock(double amount) {
        super(new BothTeamsScoredAndUnder(amount));
    }


}