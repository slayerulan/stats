package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.match.FavoriteScoredBothPeriods;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FavoriteScoredBothPeriodsBlock extends GeneralBetContainer {

    public FavoriteScoredBothPeriodsBlock() {
        super(new FavoriteScoredBothPeriods());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
