package com.savik.general.blocks.total.over;

import com.savik.bets.general.total.over.PeriodLoserOver;
import com.savik.PeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class PeriodLoserOverSingleBlock extends PeriodFavoriteBetContainer {

    public PeriodLoserOverSingleBlock(double amount) {
        super(new PeriodLoserOver(amount));
    }


}
