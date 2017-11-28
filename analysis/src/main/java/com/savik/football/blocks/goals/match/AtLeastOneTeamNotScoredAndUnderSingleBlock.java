package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.AtLeastOneTeamNotScoredAndUnder;
import com.savik.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class AtLeastOneTeamNotScoredAndUnderSingleBlock extends GeneralBetContainer {

    public AtLeastOneTeamNotScoredAndUnderSingleBlock(double amount) {
        super(new AtLeastOneTeamNotScoredAndUnder(amount));
    }


}
