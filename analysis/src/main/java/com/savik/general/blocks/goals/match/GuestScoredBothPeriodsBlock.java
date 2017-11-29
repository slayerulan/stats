package com.savik.general.blocks.goals.match;

import com.savik.football.bets.goals.match.GuestScoredBothPeriods;
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
