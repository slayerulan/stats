package com.savik.blocks.general.other;

import com.savik.Match;
import com.savik.PeriodBet;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.other.PeriodWinAndOver;
import com.savik.bets.general.other.PeriodWinAndUnder;

public class PeriodWinAndUnderSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodWinAndUnderSingleBlock(double amount, PeriodBet whoWon) {
        super(new PeriodWinAndUnder(amount, whoWon));
    }

}
