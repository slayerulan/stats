package com.savik;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class GeneralBetContainer<T extends Match> extends BetContainer<T> {

    private GeneralBet bet;

    public GeneralBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public GeneralBetContainer(GeneralBet bet) {
        super();
        this.bet = bet;
    }

    @Override
    public boolean canAnalyze(T footballMatch) {
        return bet.canAnalyze(footballMatch);
    }

    @Override
    public boolean checkMatch(T footballMatch) {
        return bet.check(footballMatch);
    }
}
