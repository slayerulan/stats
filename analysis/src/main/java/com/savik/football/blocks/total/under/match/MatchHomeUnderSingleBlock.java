package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.PeriodHomeUnder;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchHomeUnderSingleBlock extends MatchPeriodBetContainer {

    public MatchHomeUnderSingleBlock(double amount) {
        super(new PeriodHomeUnder(amount));
    }


}
