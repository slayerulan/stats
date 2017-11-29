package com.savik.blocks.general.goals.match;

import com.savik.bets.football.goals.match.GuestScoredBothPeriods;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestScoredBothPeriodsBlock extends GeneralBetContainer<FootballMatch> {

    public GuestScoredBothPeriodsBlock() {
        super(new GuestScoredBothPeriods());
    }


}
