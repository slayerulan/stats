package com.savik.football.blocks.total.over;

import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.blocks.FirstPeriodBetContainer;
import com.savik.football.blocks.PeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodHomeOverSingleBlock extends PeriodBetContainer {

    public PeriodHomeOverSingleBlock(double amount) {
        super(new PeriodHomeOver(amount));
    }

}
