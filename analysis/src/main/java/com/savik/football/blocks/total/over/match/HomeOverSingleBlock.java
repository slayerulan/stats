package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.match.MatchHomeOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeOverSingleBlock extends GeneralBetContainer {

    public HomeOverSingleBlock(int amount) {
        super(new MatchHomeOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
