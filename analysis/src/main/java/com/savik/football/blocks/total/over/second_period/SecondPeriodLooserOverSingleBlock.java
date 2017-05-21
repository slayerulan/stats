package com.savik.football.blocks.total.over.second_period;

import com.savik.football.bets.total.over.second_period.SecondPeriodLoserOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class SecondPeriodLooserOverSingleBlock extends GeneralBetContainer {

    public SecondPeriodLooserOverSingleBlock(int amount) {
        super(new SecondPeriodLoserOver(amount));
    }


}
