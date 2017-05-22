package com.savik.football.blocks.total.under.second_period;

import com.savik.football.bets.total.under.second_period.SecondPeriodHomeUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeUnderSingleBlock extends GeneralBetContainer {

    public SecondPeriodHomeUnderSingleBlock(double amount) {
        super(new SecondPeriodHomeUnder(amount));
    }


}
