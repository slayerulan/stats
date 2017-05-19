package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.match.MatchHomeUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeUnderSingleBlock extends GeneralBetContainer {

    public MatchHomeUnderSingleBlock(int amount) {
        super(new MatchHomeUnder(amount));
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
