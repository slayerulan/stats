package com.savik.blocks.football.goals.match;

import com.savik.bets.football.goals.match.FavoriteScoredBothPeriods;
import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteScoredBothPeriodsBlock extends GeneralBetContainer<FootballMatch> {

    public FavoriteScoredBothPeriodsBlock() {
        super(new FavoriteScoredBothPeriods());
    }


}
