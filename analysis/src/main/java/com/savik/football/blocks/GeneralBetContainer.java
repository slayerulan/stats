package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;

public abstract class GeneralBetContainer {

    private List<GeneralBetContainer> childrenBetBlocks;

    private GeneralBet bet;

    private Integer analyzedMatchesAmount;

    private Integer skippedMatchesAmount;

    private Integer successfullyMatchesAmount;

    public GeneralBetContainer(List<GeneralBetContainer> childrenBetBlocks) {
        this(childrenBetBlocks, null);
    }

    public GeneralBetContainer(GeneralBet bet) {
        this(null, bet);
    }

    public GeneralBetContainer(List<GeneralBetContainer> childrenBetBlocks, GeneralBet bet) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.bet = bet;
        if(isLeaf()) {
            analyzedMatchesAmount = 0;
            skippedMatchesAmount = 0;
            successfullyMatchesAmount = 0;
        }
    }

    public void check(Match match) {
        if (isLeaf()) {
            if (bet.canAnalyze(match)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(match);
                if(success) {
                    successfullyMatchesAmount++;
                }
            } else {
                skippedMatchesAmount++;
            }
        } else {
            childrenBetBlocks.forEach(b -> b.check(match));
        }
    }

    public abstract boolean isLeaf();
}
