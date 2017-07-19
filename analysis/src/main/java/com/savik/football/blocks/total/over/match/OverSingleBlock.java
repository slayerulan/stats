package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodOver;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class OverSingleBlock extends MatchPeriodBetContainer {

    public OverSingleBlock(double amount) {
        super(new PeriodOver(amount));
    }


}
