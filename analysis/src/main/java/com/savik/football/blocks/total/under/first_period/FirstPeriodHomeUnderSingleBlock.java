package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.PeriodHomeUnder;
import com.savik.football.blocks.FirstPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeUnderSingleBlock extends FirstPeriodBetContainer {

    public FirstPeriodHomeUnderSingleBlock(double amount) {
        super(new PeriodHomeUnder(amount));
    }


}
