package com.savik.football.blocks.total.over.match;

import com.savik.football.bets.total.over.PeriodLoserOver;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class LoserOverSingleBlock extends MatchPeriodFavoriteBetContainer {

    public LoserOverSingleBlock(double amount) {
        super(new PeriodLoserOver(amount));
    }


}