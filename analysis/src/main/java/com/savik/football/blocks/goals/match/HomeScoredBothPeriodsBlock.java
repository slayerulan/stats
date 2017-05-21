package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.HomeScoredBothPeriods;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeScoredBothPeriodsBlock extends GeneralBetContainer {

    public HomeScoredBothPeriodsBlock() {
        super(new HomeScoredBothPeriods());
    }


}
