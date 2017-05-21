package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.AtLeastOneTeamNotScoredAndUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class AtLeastOneTeamNotScoredAndUnderSingleBlock extends GeneralBetContainer {

    public AtLeastOneTeamNotScoredAndUnderSingleBlock(int amount) {
        super(new AtLeastOneTeamNotScoredAndUnder(amount));
    }


}
