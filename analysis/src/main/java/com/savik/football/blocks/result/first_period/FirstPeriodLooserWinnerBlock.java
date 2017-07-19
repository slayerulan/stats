package com.savik.football.blocks.result.first_period;

import com.savik.football.bets.result.PeriodLooserWinner;
import com.savik.football.blocks.FirstPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodLooserWinnerBlock extends FirstPeriodFavoriteBetContainer {

    public FirstPeriodLooserWinnerBlock() {
        super(new PeriodLooserWinner());
    }


}
