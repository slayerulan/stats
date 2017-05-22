package com.savik.football.blocks.handicap.first_period;

import com.savik.football.bets.goals.first_period.FirstPeriodBothTeamsScored;
import com.savik.football.bets.handicap.first_period.FirstPeriodFavoriteHandicap;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class FirstPeriodFavoriteHandicapSingleBlock extends GeneralBetContainer {

    public FirstPeriodFavoriteHandicapSingleBlock(double amount) {
        super(new FirstPeriodFavoriteHandicap(amount));
    }


}
