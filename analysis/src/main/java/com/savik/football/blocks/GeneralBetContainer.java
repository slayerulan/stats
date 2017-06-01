package com.savik.football.blocks;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savik.football.bets.GeneralBet;
import com.savik.football.model.FootballMatch;
import lombok.*;

@Getter
public abstract class GeneralBetContainer {

    private List<GeneralBetContainer> childrenBetBlocks;

    private GeneralBet bet;

    private Boolean leaf;

    private String type;

    private Integer analyzedMatchesAmount;

    private Integer skippedMatchesAmount;

    private Integer successfullyMatchesAmount;

    public GeneralBetContainer(List<GeneralBetContainer> childrenBetBlocks) {
        this.childrenBetBlocks = childrenBetBlocks;
        this.leaf = false;
    }

    public GeneralBetContainer(List<GeneralBetContainer> childrenBetBlocks, String type) {
        this(childrenBetBlocks);
        this.type = type;
    }

    public GeneralBetContainer(GeneralBet bet) {
        this.bet = bet;
        this.leaf = true;
        this.analyzedMatchesAmount = 0;
        this.skippedMatchesAmount = 0;
        this.successfullyMatchesAmount = 0;
    }

    public GeneralBetContainer(GeneralBet bet, String type) {
        this(bet);
        this.type = type;
    }

    @JsonProperty("percentage")
    public Integer getPercentage() {
        if (!leaf || analyzedMatchesAmount == 0) {
            return null;
        }
        return (successfullyMatchesAmount * 100) / analyzedMatchesAmount;
    }

    public void check(FootballMatch footballMatch) {
        if (leaf) {
            if (bet.canAnalyze(footballMatch)) {
                analyzedMatchesAmount++;
                boolean success = bet.check(footballMatch);
                if (success) {
                    successfullyMatchesAmount++;
                }
            } else {
                skippedMatchesAmount++;
            }
        } else {
            childrenBetBlocks.forEach(b -> b.check(footballMatch));
        }
    }
}
