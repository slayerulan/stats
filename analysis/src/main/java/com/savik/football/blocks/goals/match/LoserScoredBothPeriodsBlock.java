package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.LoserScoredBothPeriods;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LoserScoredBothPeriodsBlock extends GeneralBetContainer<FootballMatch> {

    public LoserScoredBothPeriodsBlock() {
        super(new LoserScoredBothPeriods());
    }


}
