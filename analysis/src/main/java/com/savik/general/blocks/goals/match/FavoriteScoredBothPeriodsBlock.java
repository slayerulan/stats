package com.savik.general.blocks.goals.match;

import com.savik.football.bets.goals.match.FavoriteScoredBothPeriods;
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
