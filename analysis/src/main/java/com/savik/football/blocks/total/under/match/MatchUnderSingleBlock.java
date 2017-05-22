package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.match.MatchUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchUnderSingleBlock extends GeneralBetContainer {

    public MatchUnderSingleBlock(double amount) {
        super(new MatchUnder(amount));
    }


}
