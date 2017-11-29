package com.savik.blocks.general.other;

import com.savik.Match;
import com.savik.PeriodFavoriteBet;
import com.savik.PeriodFavoriteBetContainer;
import com.savik.bets.general.other.PeriodFavoriteWinAndOver;
import com.savik.bets.general.other.PeriodFavoriteWinAndUnder;

public class PeriodFavoriteWinAndUnderSingleBlock<T extends Match> extends PeriodFavoriteBetContainer<T> {

    public PeriodFavoriteWinAndUnderSingleBlock(double amount, PeriodFavoriteBet whoWon) {
        super(new PeriodFavoriteWinAndUnder(amount, whoWon));
    }

}
