package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.match.MatchLoserOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LooserOverSingleBlock extends GeneralBetContainer {

    public LooserOverSingleBlock(int amount) {
        super(new MatchLoserOver(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
