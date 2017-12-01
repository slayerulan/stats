package com.savik;

import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
public abstract class PeriodFavoriteBetContainer<T extends Match> extends BetContainer<T> {

    private PeriodFavoriteBet bet;

    private Function<T, Period> function;


    public PeriodFavoriteBetContainer(List<? extends PeriodFavoriteBetContainer> childrenBetBlocks, Function<T, Period> function) {
        super(childrenBetBlocks);
        childrenBetBlocks.forEach((PeriodFavoriteBetContainer periodBetContainer) ->
                periodBetContainer.function = function);
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet, Function<T, Period> function) {
        this(bet);
        this.function = function;
    }

    public PeriodFavoriteBetContainer(PeriodFavoriteBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(T match) {
        if(match.getBookieStats() == null) {
            return false;
        }
        Who favorite = match.getBookieStats().getFavorite();
        Period period = function.apply(match);
        return bet.canAnalyze(favorite, period);
    }

    @Override
    public boolean checkMatch(T match) {
        Who favorite = match.getBookieStats().getFavorite();
        Period period = function.apply(match);
        return bet.check(favorite, period);
    }

}
