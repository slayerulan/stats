package com.savik.blocks.general.other;

import com.savik.*;
import com.savik.bets.general.other.PeriodWinAndOver;
import com.savik.bets.general.other.PeriodWinAndUnder;

import java.util.function.Function;

public class PeriodWinAndUnderSingleBlock<T extends Match> extends PeriodBetContainer<T> {

    public PeriodWinAndUnderSingleBlock(double amount, PeriodBet whoWon, ContainerType type) {
        super(new PeriodWinAndUnder(amount, whoWon), type);
    }

    public PeriodWinAndUnderSingleBlock(double amount, PeriodBet whoWon,  Function<T, Period> function) {
        super(new PeriodWinAndUnder(amount, whoWon), function);
    }

}
