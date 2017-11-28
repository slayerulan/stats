package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.AtLeastOneTeamNotScoredAndUnder;
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
