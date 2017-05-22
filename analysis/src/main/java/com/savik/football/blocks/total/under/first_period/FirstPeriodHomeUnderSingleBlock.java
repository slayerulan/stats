package com.savik.football.blocks.total.under.first_period;

import com.savik.football.bets.total.under.first_period.FirstPeriodHomeUnder;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeUnderSingleBlock extends GeneralBetContainer {

    public FirstPeriodHomeUnderSingleBlock(double amount) {
        super(new FirstPeriodHomeUnder(amount));
    }


}