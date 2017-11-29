package com.savik.blocks.football.goals.match;

import com.savik.bets.football.goals.match.LoserScoredBothPeriods;
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
