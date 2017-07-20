package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodLooserOver;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LooserOverSingleBlock extends MatchPeriodFavoriteBetContainer {

    public LooserOverSingleBlock(double amount) {
        super(new PeriodLooserOver(amount));
    }


}
