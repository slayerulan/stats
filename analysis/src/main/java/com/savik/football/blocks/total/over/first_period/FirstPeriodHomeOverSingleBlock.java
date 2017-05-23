package com.savik.football.blocks.total.over.first_period;

import com.savik.football.bets.total.over.first_period.FirstPeriodHomeOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodHomeOverSingleBlock extends GeneralBetContainer {

    public FirstPeriodHomeOverSingleBlock(double amount) {
        super(new FirstPeriodHomeOver(amount), "Команда забьет в 1 тайме");
    }


}
