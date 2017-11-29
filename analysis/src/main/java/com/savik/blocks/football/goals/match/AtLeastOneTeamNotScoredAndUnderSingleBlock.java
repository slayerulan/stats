package com.savik.blocks.football.goals.match;

import com.savik.bets.football.goals.match.AtLeastOneTeamNotScoredAndUnder;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class AtLeastOneTeamNotScoredAndUnderSingleBlock extends GeneralBetContainer<FootballMatch> {

    public AtLeastOneTeamNotScoredAndUnderSingleBlock(double amount) {
        super(new AtLeastOneTeamNotScoredAndUnder(amount));
    }


}
