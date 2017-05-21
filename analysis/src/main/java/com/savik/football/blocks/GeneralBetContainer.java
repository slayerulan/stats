package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.GeneralBet;
import com.savik.football.model.Match;
import lombok.Getter;

@Getter
public abstract class GeneralBetContainer {

    private List<GeneralBetContainer> childrenBetBlocks;

    private GeneralBet bet;

    private Boolean leaf;

    private Integer analyzedMatchesAmount;

    private Integer skippedMatchesAmount;

    private Integer successfullyMatchesAmount;

    public GeneralBetContainer(List<GeneralBetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public GeneralBetContainer(GeneralBet bet) {
        this.bet = bet;
        this.leaf = true;
        this.analyzedMatchesAmount = 0;
        this.skippedMatchesAmount = 0;
        this.successfullyMatchesAmount = 0;
    }


    public void check(Match match) {
        if (leaf) {
            if (bet.canAnalyze(match)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(match);
                if (success) {
                    successfullyMatchesAmount++;
                }
            } else {
                skippedMatchesAmount++;
            }
        } else {
            childrenBetBlocks.forEach(b -> b.check(match));
        }
    }
}
