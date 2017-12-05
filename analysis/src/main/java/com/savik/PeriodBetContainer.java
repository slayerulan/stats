package com.savik;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public class PeriodBetContainer<T extends Match> extends BetContainer<T> {

    private PeriodBet bet;

    @JsonIgnore
    private Function<T, Period> function;

    public PeriodBetContainer(List<? extends PeriodBetContainer> childrenBetBlocks, Function<T, Period> function, ContainerType containerType) {
        super(childrenBetBlocks, containerType);
        childrenBetBlocks.forEach((PeriodBetContainer periodBetContainer) ->
                periodBetContainer.function = function);
    }

    public PeriodBetContainer(List<? extends PeriodBetContainer> childrenBetBlocks, Function<T, Period> function) {
        this(childrenBetBlocks, function, null);
    }

    public PeriodBetContainer(PeriodBet bet, Function<T, Period> function, ContainerType containerType) {
        super(containerType);
        this.bet = bet;
        this.function = function;
    }

    public PeriodBetContainer(PeriodBet bet, Function<T, Period> function) {
        this(bet, function, null);
    }

    public PeriodBetContainer(PeriodBet bet, ContainerType type) {
        this(bet, null, type);
    }

    public PeriodBetContainer(PeriodBet bet) {
        this(bet, null, null);
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
