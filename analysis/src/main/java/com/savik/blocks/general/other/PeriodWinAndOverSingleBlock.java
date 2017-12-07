package com.savik.blocks.general.other;

import com.savik.*;
import com.savik.bets.general.other.PeriodWinAndOver;

import java.util.function.Function;

public class PeriodWinAndOverSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodWinAndOverSingleBlock(double amount, PeriodBet whoWon, ContainerType type) {
        super(new PeriodWinAndOver(amount, whoWon), type);
    }

    public PeriodWinAndOverSingleBlock(double amount, PeriodBet whoWon,  Function<T, Period> function) {
        super(new PeriodWinAndOver(amount, whoWon), function);
    }

}
