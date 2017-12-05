package com.savik.blocks.general.other;

import com.savik.ContainerType;
import com.savik.Match;
import com.savik.PeriodBet;
import com.savik.PeriodBetContainer;
import com.savik.bets.general.other.PeriodWinAndOver;

public class PeriodWinAndOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodWinAndOverSingleBlock(double amount, PeriodBet whoWon, ContainerType type) {
        super(new PeriodWinAndOver(amount, whoWon), type);
    }

}
