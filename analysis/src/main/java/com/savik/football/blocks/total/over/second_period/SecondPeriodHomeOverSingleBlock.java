package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.second_period.SecondPeriodHomeOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodHomeOverSingleBlock extends GeneralBetContainer {

    public SecondPeriodHomeOverSingleBlock(int amount) {
        super(new SecondPeriodHomeOver(amount));
    }


}
