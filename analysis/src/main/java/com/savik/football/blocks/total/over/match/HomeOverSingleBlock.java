package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodHomeOver;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeOverSingleBlock extends MatchPeriodBetContainer {

    public HomeOverSingleBlock(double amount) {
        super(new PeriodHomeOver(amount));
    }


}
