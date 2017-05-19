package com.savik.football.blocks.total.over.periods;

import com.savik.football.bets.total.over.match.MatchFavoriteOver;
import com.savik.football.bets.total.over.periods.EveryPeriodOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class EveryPeriodOverSingleBlock extends GeneralBetContainer {

    public EveryPeriodOverSingleBlock(int amount) {
        super(new EveryPeriodOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
