package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.over.match.MatchOver;
import com.savik.football.bets.total.under.match.MatchUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchUnderSingleBlock extends GeneralBetContainer {

    public MatchUnderSingleBlock(int amount) {
        super(new MatchUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
