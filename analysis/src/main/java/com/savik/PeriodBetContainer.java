package com.savik;

import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public abstract class PeriodBetContainer<T extends Match> extends BetContainer<T> {

    private PeriodBet bet;

    private Function<T, Period> function;

    public PeriodBetContainer(List<? extends BetContainer> childrenBetBlocks, Function<T, Period> function) {
        super(childrenBetBlocks);
        this.function = function;
    }

    public PeriodBetContainer(PeriodBet bet, Function<T, Period> function) {
        this(bet);
        this.function = function;
    }

    public PeriodBetContainer(PeriodBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(T match) {
        Period period = function.apply(match);
        return bet.canAnalyze(period);
    }

    @Override
    public boolean checkMatch(T match) {
        Period period = function.apply(match);
        return bet.check(period);
    }

}
