package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.PeriodUnder;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchUnderSingleBlock extends MatchPeriodBetContainer {

    public MatchUnderSingleBlock(double amount) {
        super(new PeriodUnder(amount));
    }


}
