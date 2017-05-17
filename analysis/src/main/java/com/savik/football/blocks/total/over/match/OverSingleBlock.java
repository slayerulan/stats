package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.match.MatchOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class OverSingleBlock extends GeneralBetContainer {

    public OverSingleBlock(int amount) {
        super(new MatchOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
