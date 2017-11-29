package com.savik.blocks.football.goals.match;

import com.savik.bets.football.goals.match.HomeScoredBothPeriods;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeScoredBothPeriodsBlock extends GeneralBetContainer<FootballMatch> {

    public HomeScoredBothPeriodsBlock() {
        super(new HomeScoredBothPeriods());
    }


}
