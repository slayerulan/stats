package com.savik.football.blocks.total.over;

import com.savik.football.bets.total.over.PeriodLoserOver;
import com.savik.football.blocks.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserOverSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserOverSingleBlock(double amount) {
        super(new PeriodLoserOver(amount));
    }


}