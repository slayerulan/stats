package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.PeriodHomeUnder;
import com.savik.football.blocks.SecondPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeUnderSingleBlock extends SecondPeriodBetContainer {

    public SecondPeriodHomeUnderSingleBlock(double amount) {
        super(new PeriodHomeUnder(amount));
    }


}
