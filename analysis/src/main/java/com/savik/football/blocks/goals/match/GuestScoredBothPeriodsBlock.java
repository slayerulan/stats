package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.GuestScoredBothPeriods;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestScoredBothPeriodsBlock extends GeneralBetContainer {

    public GuestScoredBothPeriodsBlock() {
        super(new GuestScoredBothPeriods());
    }


}
