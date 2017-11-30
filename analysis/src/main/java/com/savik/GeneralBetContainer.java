package com.savik;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class GeneralBetContainer<T extends Match> extends BetContainer<T> {

    private GeneralBet bet;

    public GeneralBetContainer(List<? extends BetContainer> childrenBetBlocks, ContainerType type) {
        super(childrenBetBlocks, type);
    }

    public GeneralBetContainer(List<? extends BetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public GeneralBetContainer(BetContainer childBetBlock, ContainerType type) {
        this(Arrays.asList(childBetBlock), type);
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
