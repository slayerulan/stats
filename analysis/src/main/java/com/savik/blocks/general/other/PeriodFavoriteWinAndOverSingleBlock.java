package com.savik.blocks.general.other;

import com.savik.Match;
import com.savik.PeriodFavoriteBet;
import com.savik.PeriodFavoriteBetContainer;
import com.savik.bets.general.other.PeriodFavoriteWinAndOver;

public class PeriodFavoriteWinAndOverSingleBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteWinAndOverSingleBlock(double amount, PeriodFavoriteBet whoWon) {
        super(new PeriodFavoriteWinAndOver(amount, whoWon));
    }

}
