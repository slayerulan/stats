package com.savik.blocks.general.goals.match;

import com.savik.bets.football.goals.match.GoalsInBothPeriods;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GoalsInBothPeriodsBlock extends GeneralBetContainer<FootballMatch> {

    public GoalsInBothPeriodsBlock() {
        super(new GoalsInBothPeriods());
    }


}
