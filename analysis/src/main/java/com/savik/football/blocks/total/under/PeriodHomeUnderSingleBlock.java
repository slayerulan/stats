package com.savik.football.blocks.total.under;

import com.savik.football.bets.total.under.PeriodHomeUnder;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeUnderSingleBlock extends PeriodBetContainer {

    public PeriodHomeUnderSingleBlock(double amount) {
        super(new PeriodHomeUnder(amount));
    }


}
