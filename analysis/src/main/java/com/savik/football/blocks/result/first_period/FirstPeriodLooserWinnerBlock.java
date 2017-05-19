package com.savik.football.blocks.result.first_period;

import com.savik.football.bets.result.first_period.FirstPeriodLooserWinner;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserWinnerBlock extends GeneralBetContainer {

    public FirstPeriodLooserWinnerBlock() {
        super(new FirstPeriodLooserWinner());
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
