package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.LoserScoredBothPeriods;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LoserScoredBothPeriodsBlock extends GeneralBetContainer {

    public LoserScoredBothPeriodsBlock() {
        super(new LoserScoredBothPeriods());
    }


}
